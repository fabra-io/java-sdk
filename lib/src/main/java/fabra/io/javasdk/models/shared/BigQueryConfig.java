package fabra.io.javasdk.models.shared;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BigQueryConfig {
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("credentials")
    public String credentials;
    public BigQueryConfig withCredentials(String credentials) {
        this.credentials = credentials;
        return this;
    }
    
    @JsonProperty("location")
    public String location;
    public BigQueryConfig withLocation(String location) {
        this.location = location;
        return this;
    }
    
}
