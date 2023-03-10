package fabra.io.javasdk.models.operations;

import java.net.http.HttpResponse;

public class CreateObjectResponse {
    public String contentType;
    public CreateObjectResponse withContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }
    
    public Integer statusCode;
    public CreateObjectResponse withStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    
    public HttpResponse<byte[]> rawResponse;
    public CreateObjectResponse withRawResponse(HttpResponse<byte[]> rawResponse) {
        this.rawResponse = rawResponse;
        return this;
    }
    
    public CreateObject200ApplicationJSON createObject200ApplicationJSONObject;
    public CreateObjectResponse withCreateObject200ApplicationJSONObject(CreateObject200ApplicationJSON createObject200ApplicationJSONObject) {
        this.createObject200ApplicationJSONObject = createObject200ApplicationJSONObject;
        return this;
    }
    
}
