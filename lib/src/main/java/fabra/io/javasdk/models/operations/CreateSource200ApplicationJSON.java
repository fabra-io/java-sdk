/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
 */

package fabra.io.javasdk.models.operations;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CreateSource200ApplicationJSON - Successfully created source
 */
public class CreateSource200ApplicationJSON {
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("source")
    public fabra.io.javasdk.models.shared.Source source;
    public CreateSource200ApplicationJSON withSource(fabra.io.javasdk.models.shared.Source source) {
        this.source = source;
        return this;
    }
    

    public CreateSource200ApplicationJSON(){}
}
