package fabra.io.javasdk.models.operations;

import fabra.io.javasdk.utils.SpeakeasyMetadata;

public class CreateSyncRequest {
    @SpeakeasyMetadata("request:mediaType=application/json")
    public fabra.io.javasdk.models.shared.SyncInput request;
    public CreateSyncRequest withRequest(fabra.io.javasdk.models.shared.SyncInput request) {
        this.request = request;
        return this;
    }
    
}
