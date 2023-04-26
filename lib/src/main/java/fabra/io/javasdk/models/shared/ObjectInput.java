/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
 */

package fabra.io.javasdk.models.shared;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ObjectInput {
    @JsonProperty("destination_id")
    public Long destinationId;
    public ObjectInput withDestinationId(Long destinationId) {
        this.destinationId = destinationId;
        return this;
    }
    
    @JsonProperty("display_name")
    public String displayName;
    public ObjectInput withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }
    
    /**
     * This is where Fabra will insert the End Customer ID specified when creating a source.
     */
    @JsonProperty("end_customer_id_field")
    public String endCustomerIdField;
    public ObjectInput withEndCustomerIdField(String endCustomerIdField) {
        this.endCustomerIdField = endCustomerIdField;
        return this;
    }
    
    @JsonProperty("namespace")
    public String namespace;
    public ObjectInput withNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("object_fields")
    public ObjectField[] objectFields;
    public ObjectInput withObjectFields(ObjectField[] objectFields) {
        this.objectFields = objectFields;
        return this;
    }
    
    @JsonProperty("table_name")
    public String tableName;
    public ObjectInput withTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }
    
    public ObjectInput(@JsonProperty("destination_id") Long destinationId, @JsonProperty("display_name") String displayName, @JsonProperty("end_customer_id_field") String endCustomerIdField, @JsonProperty("namespace") String namespace, @JsonProperty("table_name") String tableName) {
        this.destinationId = destinationId;
        this.displayName = displayName;
        this.endCustomerIdField = endCustomerIdField;
        this.namespace = namespace;
        this.tableName = tableName;
  }
}
