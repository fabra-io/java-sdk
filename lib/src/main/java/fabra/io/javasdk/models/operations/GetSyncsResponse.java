package fabra.io.javasdk.models.operations;

import java.net.http.HttpResponse;

public class GetSyncsResponse {
    public String contentType;
    public GetSyncsResponse withContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }
    
    public Integer statusCode;
    public GetSyncsResponse withStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    
    public HttpResponse<byte[]> rawResponse;
    public GetSyncsResponse withRawResponse(HttpResponse<byte[]> rawResponse) {
        this.rawResponse = rawResponse;
        return this;
    }
    
    public GetSyncs200ApplicationJSON getSyncs200ApplicationJSONObject;
    public GetSyncsResponse withGetSyncs200ApplicationJSONObject(GetSyncs200ApplicationJSON getSyncs200ApplicationJSONObject) {
        this.getSyncs200ApplicationJSONObject = getSyncs200ApplicationJSONObject;
        return this;
    }
    
}
