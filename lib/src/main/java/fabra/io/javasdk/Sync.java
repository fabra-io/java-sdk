package fabra.io.javasdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import fabra.io.javasdk.utils.HTTPClient;
import fabra.io.javasdk.utils.HTTPRequest;
import fabra.io.javasdk.utils.JSON;
import fabra.io.javasdk.utils.SerializedBody;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class Sync {
	
	private HTTPClient _defaultClient;
	private HTTPClient _securityClient;
	private String _serverUrl;
	private String _language;
	private String _sdkVersion;
	private String _genVersion;

	public Sync(HTTPClient defaultClient, HTTPClient securityClient, String serverUrl, String language, String sdkVersion, String genVersion) {
		this._defaultClient = defaultClient;
		this._securityClient = securityClient;
		this._serverUrl = serverUrl;
		this._language = language;
		this._sdkVersion = sdkVersion;
		this._genVersion = genVersion;
	}
	
    
    /**
     * createSync - Create a new sync
    **/
    public fabra.io.javasdk.models.operations.CreateSyncResponse createSync(fabra.io.javasdk.models.operations.CreateSyncRequest request) throws Exception {
        String baseUrl = this._serverUrl;
        String url = fabra.io.javasdk.utils.Utils.generateURL(baseUrl, "/sync");
        
        HTTPRequest req = new HTTPRequest();
        req.setMethod("POST");
        req.setURL(url);
        SerializedBody serializedRequestBody = fabra.io.javasdk.utils.Utils.serializeRequestBody(request, "request", "json");
        if (serializedRequestBody == null) {
            throw new Exception("Request body is required");
        }
        req.setBody(serializedRequestBody);
        
        
        HTTPClient client = this._securityClient;
        
        HttpResponse<byte[]> httpRes = client.send(req);

        String contentType = httpRes.headers().firstValue("Content-Type").orElse("application/octet-stream");

        fabra.io.javasdk.models.operations.CreateSyncResponse res = new fabra.io.javasdk.models.operations.CreateSyncResponse() {{
            createSync200ApplicationJSONObject = null;
        }};
        res.statusCode = httpRes.statusCode();
        res.contentType = contentType;
        res.rawResponse = httpRes;
        
        if (httpRes.statusCode() == 200) {
            if (fabra.io.javasdk.utils.Utils.matchContentType(contentType, "application/json")) {
                ObjectMapper mapper = JSON.getMapper();
                fabra.io.javasdk.models.operations.CreateSync200ApplicationJSON out = mapper.readValue(new String(httpRes.body(), StandardCharsets.UTF_8), fabra.io.javasdk.models.operations.CreateSync200ApplicationJSON.class);
                res.createSync200ApplicationJSONObject = out;
            }
        }
        else if (httpRes.statusCode() == 401 || httpRes.statusCode() == 500) {
        }

        return res;
    }
	
    
    /**
     * getSyncs - Get all syncs
    **/
    public fabra.io.javasdk.models.operations.GetSyncsResponse getSyncs() throws Exception {
        String baseUrl = this._serverUrl;
        String url = fabra.io.javasdk.utils.Utils.generateURL(baseUrl, "/syncs");
        
        HTTPRequest req = new HTTPRequest();
        req.setMethod("GET");
        req.setURL(url);
        
        
        HTTPClient client = this._securityClient;
        
        HttpResponse<byte[]> httpRes = client.send(req);

        String contentType = httpRes.headers().firstValue("Content-Type").orElse("application/octet-stream");

        fabra.io.javasdk.models.operations.GetSyncsResponse res = new fabra.io.javasdk.models.operations.GetSyncsResponse() {{
            getSyncs200ApplicationJSONObject = null;
        }};
        res.statusCode = httpRes.statusCode();
        res.contentType = contentType;
        res.rawResponse = httpRes;
        
        if (httpRes.statusCode() == 200) {
            if (fabra.io.javasdk.utils.Utils.matchContentType(contentType, "application/json")) {
                ObjectMapper mapper = JSON.getMapper();
                fabra.io.javasdk.models.operations.GetSyncs200ApplicationJSON out = mapper.readValue(new String(httpRes.body(), StandardCharsets.UTF_8), fabra.io.javasdk.models.operations.GetSyncs200ApplicationJSON.class);
                res.getSyncs200ApplicationJSONObject = out;
            }
        }
        else if (httpRes.statusCode() == 401 || httpRes.statusCode() == 500) {
        }

        return res;
    }
}