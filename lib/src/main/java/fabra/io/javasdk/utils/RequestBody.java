package fabra.io.javasdk.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.http.HttpRequest.BodyPublishers;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.message.BasicNameValuePair;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestBody {
    public static SerializedBody serialize(Object request)
            throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException,
            UnsupportedOperationException, IOException {
        if (request == null) {
            return null;
        }

        Field requestField = request.getClass().getField("request");
        if (requestField == null) {
            throw new Error("Request object must have a field named 'request'");
        }

        Object requestValue = requestField.get(request);

        if (requestValue == null) {
            return null;
        }

        RequestMetadata requestMetadata = RequestMetadata.parse(requestField);
        if (requestMetadata != null) {
            return serializeContentType("request", requestMetadata.mediaType, requestValue);
        }

        Field[] fields = requestValue.getClass().getFields();

        for (Field field : fields) {
            Object val = field.get(requestValue);
            if (val == null) {
                continue;
            }

            RequestMetadata metadata = RequestMetadata.parse(field);
            if (metadata == null) {
                throw new Error("Missing request metadata on field " + field.getName());
            }

            return serializeContentType(field.getName(), metadata.mediaType, val);
        }

        return null;
    }

    private static SerializedBody serializeContentType(String fieldName, String contentType, Object value)
            throws IllegalArgumentException, IllegalAccessException, UnsupportedOperationException, IOException {
        Pattern jsonPattern = Pattern.compile("(application|text)\\/.*?\\+*json.*");
        Pattern multipartPattern = Pattern.compile("multipart\\/.*");
        Pattern formPattern = Pattern.compile("application\\/x-www-form-urlencoded.*");
        Pattern textPattern = Pattern.compile("text\\/plain");

        SerializedBody body = new SerializedBody();

        if (textPattern.matcher(contentType).matches()) {
            body.contentType = contentType;
            body.body = BodyPublishers.ofString(value.toString());
        } else if (jsonPattern.matcher(contentType).matches()) {
            ObjectMapper mapper = JSON.getMapper();
            body.contentType = contentType;
            body.body = BodyPublishers.ofString(mapper.writeValueAsString(value));
        } else if (multipartPattern.matcher(contentType).matches()) {
            body = serializeMultipart(value);
        } else if (formPattern.matcher(contentType).matches()) {
            body = serializeFormData(value);
        } else {
            if (value instanceof String) {
                body.contentType = contentType;
                body.body = BodyPublishers.ofString((String) value);
            } else if (value instanceof byte[]) {
                body.contentType = contentType;
                body.body = BodyPublishers.ofByteArray((byte[]) value);
            } else {
                throw new Error("Unsupported content type " + contentType + " for field " + fieldName);
            }
        }

        return body;
    }

    private static SerializedBody serializeMultipart(Object value)
            throws IllegalArgumentException, IllegalAccessException, UnsupportedOperationException, IOException {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        String boundary = "-------------" + System.currentTimeMillis();
        builder.setBoundary(boundary);

        Field[] fields = value.getClass().getFields();

        for (Field field : fields) {
            Object val = field.get(value);

            if (val == null) {
                continue;
            }

            MultipartFormMetadata metadata = MultipartFormMetadata.parse(field);
            if (metadata == null) {
                throw new Error("Missing multipart form metadata on field " + field.getName());
            }

            if (metadata.file) {
                serializeMultipartFile(builder, val);
            } else if (metadata.json) {
                ObjectMapper mapper = JSON.getMapper();
                String json = mapper.writeValueAsString(val);
                builder.addTextBody(metadata.name, json, ContentType.APPLICATION_JSON);
            } else {
                if (val.getClass().isArray()) {
                    Object[] arr = (Object[]) val;
                    for (Object item : arr) {
                        builder.addTextBody(metadata.name + "[]", Utils.valToString(item));
                    }
                } else {
                    builder.addTextBody(metadata.name, Utils.valToString(val));
                }
            }
        }

        HttpEntity entity = builder.build();

        SerializedBody body = new SerializedBody();
        body.contentType = builder.build().getContentType().getValue();

        InputStream stream = entity.getContent();

        body.body = BodyPublishers.ofInputStream(() -> stream);

        return body;
    }

    private static void serializeMultipartFile(MultipartEntityBuilder builder, Object file)
            throws IllegalArgumentException, IllegalAccessException {
        if (Types.getType(file.getClass()) != Types.OBJECT) {
            throw new Error("Invalid type for multipart file");
        }

        String fieldName = "";
        String fileName = "";
        byte[] content = null;

        Field[] fields = file.getClass().getFields();

        for (Field field : fields) {
            Object val = field.get(file);

            if (val == null) {
                continue;
            }

            MultipartFormMetadata metadata = MultipartFormMetadata.parse(field);
            if (metadata == null || (!metadata.content && (metadata.name == null || metadata.name.isBlank()))) {
                continue;
            }

            if (metadata.content) {
                content = (byte[]) val;
            } else {
                fieldName = metadata.name;
                fileName = Utils.valToString(val);
            }
        }

        if (fieldName.isBlank() || fileName.isBlank() || content == null) {
            throw new Error("Invalid multipart file");
        }

        builder.addBinaryBody(fieldName, content, ContentType.APPLICATION_OCTET_STREAM, fileName);
    }

    private static SerializedBody serializeFormData(Object value)
            throws IOException, IllegalArgumentException, IllegalAccessException {
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        switch (Types.getType(value.getClass())) {
            case MAP:
                Map<?, ?> map = (Map<?, ?>) value;

                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    params.add(
                            new BasicNameValuePair(Utils.valToString(entry.getKey()),
                                    Utils.valToString(entry.getValue())));
                }
                break;
            case OBJECT:
                Field[] fields = value.getClass().getFields();

                for (Field field : fields) {
                    Object val = field.get(value);

                    if (val == null) {
                        continue;
                    }

                    FormMetadata metadata = FormMetadata.parse(field);
                    if (metadata == null) {
                        continue;
                    }

                    if (metadata.json) {
                        ObjectMapper mapper = JSON.getMapper();
                        String json = mapper.writeValueAsString(val);
                        params.add(new BasicNameValuePair(metadata.name, json));
                    } else {
                        switch (Types.getType(val.getClass())) {
                            case OBJECT: {
                                if (val.getClass() == LocalDate.class) {
                                    params.add(new BasicNameValuePair(metadata.name, String.valueOf(val)));
                                } else if (val.getClass() == OffsetDateTime.class) {
                                    params.add(new BasicNameValuePair(metadata.name, String.valueOf(val)));
                                } else {

                                    Field[] valFields = val.getClass().getFields();

                                    List<String> items = new ArrayList<String>();

                                    for (Field valField : valFields) {
                                        Object v = valField.get(val);
                                        if (v == null) {
                                            continue;
                                        }

                                        FormMetadata valMetadata = FormMetadata.parse(valField);
                                        if (valMetadata == null) {
                                            continue;
                                        }

                                        if (metadata.explode) {
                                            params.add(new BasicNameValuePair(valMetadata.name,
                                                    Utils.valToString(v)));
                                        } else {
                                            items.add(String.format("%s,%s", valMetadata.name,
                                                    Utils.valToString(v)));
                                        }
                                    }

                                    if (items.size() > 0) {
                                        params.add(new BasicNameValuePair(metadata.name, String.join(",", items)));
                                    }
                                }
                                break;
                            }
                            case MAP: {
                                Map<?, ?> valMap = (Map<?, ?>) val;

                                List<String> items = new ArrayList<String>();

                                for (Map.Entry<?, ?> entry : valMap.entrySet()) {
                                    if (metadata.explode) {
                                        params.add(new BasicNameValuePair(Utils.valToString(entry.getKey()),
                                                Utils.valToString(entry.getValue())));
                                    } else {
                                        items.add(String.format("%s,%s", entry.getKey(), entry.getValue()));
                                    }
                                }

                                if (items.size() > 0) {
                                    params.add(new BasicNameValuePair(metadata.name, String.join(",", items)));
                                }

                                break;
                            }
                            case ARRAY: {
                                Object[] arr = (Object[]) val;

                                List<String> items = new ArrayList<String>();

                                for (Object item : arr) {
                                    if (metadata.explode) {
                                        params.add(new BasicNameValuePair(metadata.name, Utils.valToString(item)));
                                    } else {
                                        items.add(Utils.valToString(item));
                                    }
                                }

                                if (items.size() > 0) {
                                    params.add(new BasicNameValuePair(metadata.name, String.join(",", items)));
                                }

                                break;
                            }
                            default:
                                params.add(new BasicNameValuePair(metadata.name, Utils.valToString(val)));
                                break;
                        }
                    }
                }
                break;
            default:
                throw new Error("Invalid type for form data");
        }

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params);

        SerializedBody body = new SerializedBody();
        body.contentType = entity.getContentType().getValue();

        InputStream stream = entity.getContent();

        body.body = BodyPublishers.ofInputStream(() -> stream);

        return body;
    }

    private RequestBody() {
    }
}