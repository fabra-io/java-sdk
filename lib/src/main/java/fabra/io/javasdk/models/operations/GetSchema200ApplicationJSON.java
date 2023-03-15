package fabra.io.javasdk.models.operations;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetSchema200ApplicationJSON {
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("schema")
    public fabra.io.javasdk.models.shared.Field[] schema;
    public GetSchema200ApplicationJSON withSchema(fabra.io.javasdk.models.shared.Field[] schema) {
        this.schema = schema;
        return this;
    }
    
}
