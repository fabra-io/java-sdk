/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
 */

package fabra.io.javasdk.models.shared;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Namespaces - Successfully fetched namespaces
 */
public class Namespaces {
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("namespaces")
    public String[] namespaces;
    public Namespaces withNamespaces(String[] namespaces) {
        this.namespaces = namespaces;
        return this;
    }
    

    public Namespaces(){}
}
