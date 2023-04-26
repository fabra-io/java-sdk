/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
 */

package fabra.io.javasdk.models.operations;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.http.HttpResponse;

public class GetTablesResponse {
    
    public String contentType;
    public GetTablesResponse withContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }
    
    
    public Integer statusCode;
    public GetTablesResponse withStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    
    
    public HttpResponse<byte[]> rawResponse;
    public GetTablesResponse withRawResponse(HttpResponse<byte[]> rawResponse) {
        this.rawResponse = rawResponse;
        return this;
    }
    
    /**
     * Successfully fetched tables
     */
    
    public GetTables200ApplicationJSON getTables200ApplicationJSONObject;
    public GetTablesResponse withGetTables200ApplicationJSONObject(GetTables200ApplicationJSON getTables200ApplicationJSONObject) {
        this.getTables200ApplicationJSONObject = getTables200ApplicationJSONObject;
        return this;
    }
    
    public GetTablesResponse(@JsonProperty("ContentType") String contentType, @JsonProperty("StatusCode") Integer statusCode) {
        this.contentType = contentType;
        this.statusCode = statusCode;
  }
}
