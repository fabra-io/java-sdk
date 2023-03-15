package fabra.io.javasdk.models.shared;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Object {
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("destination_id")
    public Long destinationId;
    public Object withDestinationId(Long destinationId) {
        this.destinationId = destinationId;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("display_name")
    public String displayName;
    public Object withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("end_customer_id_field")
    public String endCustomerIdField;
    public Object withEndCustomerIdField(String endCustomerIdField) {
        this.endCustomerIdField = endCustomerIdField;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("id")
    public Long id;
    public Object withId(Long id) {
        this.id = id;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("namespace")
    public String namespace;
    public Object withNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("object_fields")
    public ObjectField[] objectFields;
    public Object withObjectFields(ObjectField[] objectFields) {
        this.objectFields = objectFields;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("table_name")
    public String tableName;
    public Object withTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }
    
}
