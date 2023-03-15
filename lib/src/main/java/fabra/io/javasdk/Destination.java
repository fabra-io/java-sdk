package fabra.io.javasdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import fabra.io.javasdk.utils.HTTPClient;
import fabra.io.javasdk.utils.HTTPRequest;
import fabra.io.javasdk.utils.JSON;
import fabra.io.javasdk.utils.SerializedBody;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class Destination {
	
	private HTTPClient _defaultClient;
	private HTTPClient _securityClient;
	private String _serverUrl;
	private String _language;
	private String _sdkVersion;
	private String _genVersion;

	public Destination(HTTPClient defaultClient, HTTPClient securityClient, String serverUrl, String language, String sdkVersion, String genVersion) {
		this._defaultClient = defaultClient;
		this._securityClient = securityClient;
		this._serverUrl = serverUrl;
		this._language = language;
		this._sdkVersion = sdkVersion;
		this._genVersion = genVersion;
	}
	
    
    /**
     * createDestination - Create a new destination
    **/
    public fabra.io.javasdk.models.operations.CreateDestinationResponse createDestination(fabra.io.javasdk.models.operations.CreateDestinationRequest request) throws Exception {
        String baseUrl = this._serverUrl;
        String url = fabra.io.javasdk.utils.Utils.generateURL(baseUrl, "/destination");
        
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

        fabra.io.javasdk.models.operations.CreateDestinationResponse res = new fabra.io.javasdk.models.operations.CreateDestinationResponse() {{
            createDestination200ApplicationJSONObject = null;
        }};
        res.statusCode = httpRes.statusCode();
        res.contentType = contentType;
        res.rawResponse = httpRes;
        
        if (httpRes.statusCode() == 200) {
            if (fabra.io.javasdk.utils.Utils.matchContentType(contentType, "application/json")) {
                ObjectMapper mapper = JSON.getMapper();
                fabra.io.javasdk.models.operations.CreateDestination200ApplicationJSON out = mapper.readValue(new String(httpRes.body(), StandardCharsets.UTF_8), fabra.io.javasdk.models.operations.CreateDestination200ApplicationJSON.class);
                res.createDestination200ApplicationJSONObject = out;
            }
        }
        else if (httpRes.statusCode() == 401 || httpRes.statusCode() == 500) {
        }

        return res;
    }
	
    
    /**
     * getDestinations - Get all destinations
    **/
    public fabra.io.javasdk.models.operations.GetDestinationsResponse getDestinations() throws Exception {
        String baseUrl = this._serverUrl;
        String url = fabra.io.javasdk.utils.Utils.generateURL(baseUrl, "/destinations");
        
        HTTPRequest req = new HTTPRequest();
        req.setMethod("GET");
        req.setURL(url);
        
        
        HTTPClient client = this._securityClient;
        
        HttpResponse<byte[]> httpRes = client.send(req);

        String contentType = httpRes.headers().firstValue("Content-Type").orElse("application/octet-stream");

        fabra.io.javasdk.models.operations.GetDestinationsResponse res = new fabra.io.javasdk.models.operations.GetDestinationsResponse() {{
            getDestinations200ApplicationJSONObject = null;
        }};
        res.statusCode = httpRes.statusCode();
        res.contentType = contentType;
        res.rawResponse = httpRes;
        
        if (httpRes.statusCode() == 200) {
            if (fabra.io.javasdk.utils.Utils.matchContentType(contentType, "application/json")) {
                ObjectMapper mapper = JSON.getMapper();
                fabra.io.javasdk.models.operations.GetDestinations200ApplicationJSON out = mapper.readValue(new String(httpRes.body(), StandardCharsets.UTF_8), fabra.io.javasdk.models.operations.GetDestinations200ApplicationJSON.class);
                res.getDestinations200ApplicationJSONObject = out;
            }
        }
        else if (httpRes.statusCode() == 401 || httpRes.statusCode() == 500) {
        }

        return res;
    }
}