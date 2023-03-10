package fabra.io.javasdk.models.operations;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateObject200ApplicationJSON {
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("object")
    public fabra.io.javasdk.models.shared.Object object;
    public CreateObject200ApplicationJSON withObject(fabra.io.javasdk.models.shared.Object object) {
        this.object = object;
        return this;
    }
    
}
