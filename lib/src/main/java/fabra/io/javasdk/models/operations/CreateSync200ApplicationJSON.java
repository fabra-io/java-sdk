package fabra.io.javasdk.models.operations;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateSync200ApplicationJSON {
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("sync")
    public fabra.io.javasdk.models.shared.Sync sync;
    public CreateSync200ApplicationJSON withSync(fabra.io.javasdk.models.shared.Sync sync) {
        this.sync = sync;
        return this;
    }
    
}
