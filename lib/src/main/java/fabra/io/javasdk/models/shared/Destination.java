package fabra.io.javasdk.models.shared;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Destination {
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("connection")
    public Connection connection;
    public Destination withConnection(Connection connection) {
        this.connection = connection;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("display_name")
    public String displayName;
    public Destination withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("id")
    public Long id;
    public Destination withId(Long id) {
        this.id = id;
        return this;
    }
    
}
