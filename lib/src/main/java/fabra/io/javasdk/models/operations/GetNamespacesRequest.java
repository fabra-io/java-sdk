/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
 */

package fabra.io.javasdk.models.operations;

import fabra.io.javasdk.utils.SpeakeasyMetadata;

public class GetNamespacesRequest {
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=connectionID")
    public Long connectionID;
    public GetNamespacesRequest withConnectionID(Long connectionID) {
        this.connectionID = connectionID;
        return this;
    }
    
}
