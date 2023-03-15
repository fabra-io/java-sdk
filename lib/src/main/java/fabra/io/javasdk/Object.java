package fabra.io.javasdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import fabra.io.javasdk.utils.HTTPClient;
import fabra.io.javasdk.utils.HTTPRequest;
import fabra.io.javasdk.utils.JSON;
import fabra.io.javasdk.utils.SerializedBody;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class Object {
	
	private HTTPClient _defaultClient;
	private HTTPClient _securityClient;
	private String _serverUrl;
	private String _language;
	private String _sdkVersion;
	private String _genVersion;

	public Object(HTTPClient defaultClient, HTTPClient securityClient, String serverUrl, String language, String sdkVersion, String genVersion) {
		this._defaultClient = defaultClient;
		this._securityClient = securityClient;
		this._serverUrl = serverUrl;
		this._language = language;
		this._sdkVersion = sdkVersion;
		this._genVersion = genVersion;
	}
	
    
    /**
     * createObject - Create a new object
    **/
    public fabra.io.javasdk.models.operations.CreateObjectResponse createObject(fabra.io.javasdk.models.operations.CreateObjectRequest request) throws Exception {
        String baseUrl = this._serverUrl;
        String url = fabra.io.javasdk.utils.Utils.generateURL(baseUrl, "/object");
        
        HTTPRequest req = new HTTPRequest();
        req.setMethod("POST");
        req.setURL(url);
        SerializedBody serializedRequestBody = fabra.io.javasdk.utils.Utils.serializeRequestBody(request, "request", "json");
        if (serializedRequestBody == null) {
            throw new Exception("Request body is required");
        }
        req.setBody(serializedRequestBody);
        
        
        HTTPClient client = this._securityClient;
        
        HttpResponse<byte[]> httpRes = client.send(req);

        String contentType = httpRes.headers().firstValue("Content-Type").orElse("application/octet-stream");

        fabra.io.javasdk.models.operations.CreateObjectResponse res = new fabra.io.javasdk.models.operations.CreateObjectResponse() {{
            createObject200ApplicationJSONObject = null;
        }};
        res.statusCode = httpRes.statusCode();
        res.contentType = contentType;
        res.rawResponse = httpRes;
        
        if (httpRes.statusCode() == 200) {
            if (fabra.io.javasdk.utils.Utils.matchContentType(contentType, "application/json")) {
                ObjectMapper mapper = JSON.getMapper();
                fabra.io.javasdk.models.operations.CreateObject200ApplicationJSON out = mapper.readValue(new String(httpRes.body(), StandardCharsets.UTF_8), fabra.io.javasdk.models.operations.CreateObject200ApplicationJSON.class);
                res.createObject200ApplicationJSONObject = out;
            }
        }
        else if (httpRes.statusCode() == 401 || httpRes.statusCode() == 500) {
        }

        return res;
    }
	
    
    /**
     * getObjects - Get all objects
    **/
    public fabra.io.javasdk.models.operations.GetObjectsResponse getObjects() throws Exception {
        String baseUrl = this._serverUrl;
        String url = fabra.io.javasdk.utils.Utils.generateURL(baseUrl, "/objects");
        
        HTTPRequest req = new HTTPRequest();
        req.setMethod("GET");
        req.setURL(url);
        
        
        HTTPClient client = this._securityClient;
        
        HttpResponse<byte[]> httpRes = client.send(req);

        String contentType = httpRes.headers().firstValue("Content-Type").orElse("application/octet-stream");

        fabra.io.javasdk.models.operations.GetObjectsResponse res = new fabra.io.javasdk.models.operations.GetObjectsResponse() {{
            getObjects200ApplicationJSONObject = null;
        }};
        res.statusCode = httpRes.statusCode();
        res.contentType = contentType;
        res.rawResponse = httpRes;
        
        if (httpRes.statusCode() == 200) {
            if (fabra.io.javasdk.utils.Utils.matchContentType(contentType, "application/json")) {
                ObjectMapper mapper = JSON.getMapper();
                fabra.io.javasdk.models.operations.GetObjects200ApplicationJSON out = mapper.readValue(new String(httpRes.body(), StandardCharsets.UTF_8), fabra.io.javasdk.models.operations.GetObjects200ApplicationJSON.class);
                res.getObjects200ApplicationJSONObject = out;
            }
        }
        else if (httpRes.statusCode() == 401 || httpRes.statusCode() == 500) {
        }

        return res;
    }
}