/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
 */

package fabra.io.javasdk.models.operations;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.http.HttpResponse;

public class CreateSyncResponse {
    
    public String contentType;

    public CreateSyncResponse withContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }
    
    
    public Integer statusCode;

    public CreateSyncResponse withStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    
    
    public HttpResponse<byte[]> rawResponse;

    public CreateSyncResponse withRawResponse(HttpResponse<byte[]> rawResponse) {
        this.rawResponse = rawResponse;
        return this;
    }
    
    /**
     * Successfully created sync
     */
    
    public CreateSync200ApplicationJSON createSync200ApplicationJSONObject;

    public CreateSyncResponse withCreateSync200ApplicationJSONObject(CreateSync200ApplicationJSON createSync200ApplicationJSONObject) {
        this.createSync200ApplicationJSONObject = createSync200ApplicationJSONObject;
        return this;
    }
    
    public CreateSyncResponse(@JsonProperty("ContentType") String contentType, @JsonProperty("StatusCode") Integer statusCode) {
        this.contentType = contentType;
        this.statusCode = statusCode;
  }
}
