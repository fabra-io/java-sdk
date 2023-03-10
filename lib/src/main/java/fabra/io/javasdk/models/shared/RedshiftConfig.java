package fabra.io.javasdk.models.shared;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RedshiftConfig {
    @JsonProperty("database_name")
    public String databaseName;
    public RedshiftConfig withDatabaseName(String databaseName) {
        this.databaseName = databaseName;
        return this;
    }
    
    @JsonProperty("host")
    public String host;
    public RedshiftConfig withHost(String host) {
        this.host = host;
        return this;
    }
    
    @JsonProperty("password")
    public String password;
    public RedshiftConfig withPassword(String password) {
        this.password = password;
        return this;
    }
    
    @JsonProperty("port")
    public String port;
    public RedshiftConfig withPort(String port) {
        this.port = port;
        return this;
    }
    
    @JsonProperty("username")
    public String username;
    public RedshiftConfig withUsername(String username) {
        this.username = username;
        return this;
    }
    
}
