/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
 */

package fabra.io.javasdk.models.operations;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.http.HttpResponse;

public class GetObjectsResponse {
    
    public String contentType;
    public GetObjectsResponse withContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }
    
    
    public Integer statusCode;
    public GetObjectsResponse withStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    
    
    public HttpResponse<byte[]> rawResponse;
    public GetObjectsResponse withRawResponse(HttpResponse<byte[]> rawResponse) {
        this.rawResponse = rawResponse;
        return this;
    }
    
    /**
     * Successfully fetched objects
     */
    
    public GetObjects200ApplicationJSON getObjects200ApplicationJSONObject;
    public GetObjectsResponse withGetObjects200ApplicationJSONObject(GetObjects200ApplicationJSON getObjects200ApplicationJSONObject) {
        this.getObjects200ApplicationJSONObject = getObjects200ApplicationJSONObject;
        return this;
    }
    
    public GetObjectsResponse(@JsonProperty("ContentType") String contentType, @JsonProperty("StatusCode") Integer statusCode) {
        this.contentType = contentType;
        this.statusCode = statusCode;
  }
}
