package fabra.io.javasdk.models.shared;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Sync {
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("cursor_field")
    public String cursorField;
    public Sync withCursorField(String cursorField) {
        this.cursorField = cursorField;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("custom_join")
    public String customJoin;
    public Sync withCustomJoin(String customJoin) {
        this.customJoin = customJoin;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("destination_id")
    public Long destinationId;
    public Sync withDestinationId(Long destinationId) {
        this.destinationId = destinationId;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("display_name")
    public String displayName;
    public Sync withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("field_mappings")
    public FieldMapping[] fieldMappings;
    public Sync withFieldMappings(FieldMapping[] fieldMappings) {
        this.fieldMappings = fieldMappings;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("frequency")
    public Long frequency;
    public Sync withFrequency(Long frequency) {
        this.frequency = frequency;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("frequency_units")
    public FrequencyUnitsEnum frequencyUnits;
    public Sync withFrequencyUnits(FrequencyUnitsEnum frequencyUnits) {
        this.frequencyUnits = frequencyUnits;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("id")
    public Long id;
    public Sync withId(Long id) {
        this.id = id;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("namespace")
    public String namespace;
    public Sync withNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("object_id")
    public Long objectId;
    public Sync withObjectId(Long objectId) {
        this.objectId = objectId;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("primary_key")
    public String primaryKey;
    public Sync withPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("source_id")
    public Long sourceId;
    public Sync withSourceId(Long sourceId) {
        this.sourceId = sourceId;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("table_name")
    public String tableName;
    public Sync withTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }
    
}
