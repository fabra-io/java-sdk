package fabra.io.javasdk.models.shared;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FieldMapping {
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("destination_field_name")
    public String destinationFieldName;
    public FieldMapping withDestinationFieldName(String destinationFieldName) {
        this.destinationFieldName = destinationFieldName;
        return this;
    }
    
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("source_field_name")
    public String sourceFieldName;
    public FieldMapping withSourceFieldName(String sourceFieldName) {
        this.sourceFieldName = sourceFieldName;
        return this;
    }
    
}
