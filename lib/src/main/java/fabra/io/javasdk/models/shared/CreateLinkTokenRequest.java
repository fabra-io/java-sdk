package fabra.io.javasdk.models.shared;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateLinkTokenRequest {
    @JsonProperty("end_customer_id")
    public String endCustomerId;
    public CreateLinkTokenRequest withEndCustomerId(String endCustomerId) {
        this.endCustomerId = endCustomerId;
        return this;
    }
    
}
