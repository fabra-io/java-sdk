/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
 */

package fabra.io.javasdk.models.operations;

import fabra.io.javasdk.utils.SpeakeasyMetadata;

public class GetSchemaRequest {
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=connectionID")
    public Long connectionID;
    public GetSchemaRequest withConnectionID(Long connectionID) {
        this.connectionID = connectionID;
        return this;
    }
    
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=namespace")
    public String namespace;
    public GetSchemaRequest withNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }
    
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=tableName")
    public String tableName;
    public GetSchemaRequest withTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }
    
}
