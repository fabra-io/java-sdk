package fabra.io.javasdk.models.shared;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DestinationInput {
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("bigquery_config")
    public BigQueryConfig bigqueryConfig;
    public DestinationInput withBigqueryConfig(BigQueryConfig bigqueryConfig) {
        this.bigqueryConfig = bigqueryConfig;
        return this;
    }
    
    @JsonProperty("connection_type")
    public ConnectionTypeEnum connectionType;
    public DestinationInput withConnectionType(ConnectionTypeEnum connectionType) {
        this.connectionType = connectionType;
        return this;
    }
    
    @JsonProperty("display_name")
    public String displayName;
    public DestinationInput withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("mongodb_config")
    public MongoDbConfig mongodbConfig;
    public DestinationInput withMongodbConfig(MongoDbConfig mongodbConfig) {
        this.mongodbConfig = mongodbConfig;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("redshift_config")
    public RedshiftConfig redshiftConfig;
    public DestinationInput withRedshiftConfig(RedshiftConfig redshiftConfig) {
        this.redshiftConfig = redshiftConfig;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("snowflake_config")
    public SnowflakeConfig snowflakeConfig;
    public DestinationInput withSnowflakeConfig(SnowflakeConfig snowflakeConfig) {
        this.snowflakeConfig = snowflakeConfig;
        return this;
    }
    
}
