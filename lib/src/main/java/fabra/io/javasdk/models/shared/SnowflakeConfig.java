package fabra.io.javasdk.models.shared;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SnowflakeConfig {
    @JsonProperty("database_name")
    public String databaseName;
    public SnowflakeConfig withDatabaseName(String databaseName) {
        this.databaseName = databaseName;
        return this;
    }
    
    @JsonProperty("host")
    public String host;
    public SnowflakeConfig withHost(String host) {
        this.host = host;
        return this;
    }
    
    @JsonProperty("password")
    public String password;
    public SnowflakeConfig withPassword(String password) {
        this.password = password;
        return this;
    }
    
    @JsonProperty("role")
    public String role;
    public SnowflakeConfig withRole(String role) {
        this.role = role;
        return this;
    }
    
    @JsonProperty("username")
    public String username;
    public SnowflakeConfig withUsername(String username) {
        this.username = username;
        return this;
    }
    
    @JsonProperty("warehouse_name")
    public String warehouseName;
    public SnowflakeConfig withWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
        return this;
    }
    
}
