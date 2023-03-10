package fabra.io.javasdk.models.operations;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateDestination200ApplicationJSON {
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("destination")
    public fabra.io.javasdk.models.shared.Destination destination;
    public CreateDestination200ApplicationJSON withDestination(fabra.io.javasdk.models.shared.Destination destination) {
        this.destination = destination;
        return this;
    }
    
}
