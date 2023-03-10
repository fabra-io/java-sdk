package fabra.io.javasdk.models.shared;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Connection {
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("connection_type")
    public ConnectionTypeEnum connectionType;
    public Connection withConnectionType(ConnectionTypeEnum connectionType) {
        this.connectionType = connectionType;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("id")
    public Long id;
    public Connection withId(Long id) {
        this.id = id;
        return this;
    }
    
}
