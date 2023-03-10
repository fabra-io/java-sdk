package fabra.io.javasdk.models.shared;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SyncInput {
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("cursor_field")
    public String cursorField;
    public SyncInput withCursorField(String cursorField) {
        this.cursorField = cursorField;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("custom_join")
    public String customJoin;
    public SyncInput withCustomJoin(String customJoin) {
        this.customJoin = customJoin;
        return this;
    }
    
    @JsonProperty("destination_id")
    public Long destinationId;
    public SyncInput withDestinationId(Long destinationId) {
        this.destinationId = destinationId;
        return this;
    }
    
    @JsonProperty("display_name")
    public String displayName;
    public SyncInput withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }
    
    @JsonProperty("field_mappings")
    public FieldMapping[] fieldMappings;
    public SyncInput withFieldMappings(FieldMapping[] fieldMappings) {
        this.fieldMappings = fieldMappings;
        return this;
    }
    
    @JsonProperty("frequency")
    public Long frequency;
    public SyncInput withFrequency(Long frequency) {
        this.frequency = frequency;
        return this;
    }
    
    @JsonProperty("frequency_units")
    public FrequencyUnitsEnum frequencyUnits;
    public SyncInput withFrequencyUnits(FrequencyUnitsEnum frequencyUnits) {
        this.frequencyUnits = frequencyUnits;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("namespace")
    public String namespace;
    public SyncInput withNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }
    
    @JsonProperty("object_id")
    public Long objectId;
    public SyncInput withObjectId(Long objectId) {
        this.objectId = objectId;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("primary_key")
    public String primaryKey;
    public SyncInput withPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
        return this;
    }
    
    @JsonProperty("source_id")
    public Long sourceId;
    public SyncInput withSourceId(Long sourceId) {
        this.sourceId = sourceId;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("table_name")
    public String tableName;
    public SyncInput withTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }
    
}
