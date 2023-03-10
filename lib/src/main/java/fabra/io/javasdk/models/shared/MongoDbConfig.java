package fabra.io.javasdk.models.shared;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MongoDbConfig {
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("connection_options")
    public String connectionOptions;
    public MongoDbConfig withConnectionOptions(String connectionOptions) {
        this.connectionOptions = connectionOptions;
        return this;
    }
    
    @JsonProperty("host")
    public String host;
    public MongoDbConfig withHost(String host) {
        this.host = host;
        return this;
    }
    
    @JsonProperty("password")
    public String password;
    public MongoDbConfig withPassword(String password) {
        this.password = password;
        return this;
    }
    
    @JsonProperty("username")
    public String username;
    public MongoDbConfig withUsername(String username) {
        this.username = username;
        return this;
    }
    
}
