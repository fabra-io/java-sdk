package fabra.io.javasdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import fabra.io.javasdk.utils.HTTPClient;
import fabra.io.javasdk.utils.HTTPRequest;
import fabra.io.javasdk.utils.JSON;
import fabra.io.javasdk.utils.SerializedBody;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class LinkToken {
	
	private HTTPClient _defaultClient;
	private HTTPClient _securityClient;
	private String _serverUrl;
	private String _language;
	private String _sdkVersion;
	private String _genVersion;

	public LinkToken(HTTPClient defaultClient, HTTPClient securityClient, String serverUrl, String language, String sdkVersion, String genVersion) {
		this._defaultClient = defaultClient;
		this._securityClient = securityClient;
		this._serverUrl = serverUrl;
		this._language = language;
		this._sdkVersion = sdkVersion;
		this._genVersion = genVersion;
	}
	
    
    /**
     * createLinkToken - Create a new link token
    **/
    public fabra.io.javasdk.models.operations.CreateLinkTokenResponse createLinkToken(fabra.io.javasdk.models.operations.CreateLinkTokenRequest request) throws Exception {
        String baseUrl = this._serverUrl;
        String url = fabra.io.javasdk.utils.Utils.generateURL(baseUrl, "/link_token");
        
        HTTPRequest req = new HTTPRequest();
        req.setMethod("POST");
        req.setURL(url);
        SerializedBody serializedRequestBody = fabra.io.javasdk.utils.Utils.serializeRequestBody(request);
        if (serializedRequestBody == null) {
            throw new Exception("Request body is required");
        }
        req.setBody(serializedRequestBody);
        
        
        HTTPClient client = this._securityClient;
        
        HttpResponse<byte[]> httpRes = client.send(req);

        String contentType = httpRes.headers().firstValue("Content-Type").orElse("application/octet-stream");

        fabra.io.javasdk.models.operations.CreateLinkTokenResponse res = new fabra.io.javasdk.models.operations.CreateLinkTokenResponse() {{
            createLinkTokenResponse = null;
        }};
        res.statusCode = httpRes.statusCode();
        res.contentType = contentType;
        res.rawResponse = httpRes;
        
        if (httpRes.statusCode() == 200) {
            if (fabra.io.javasdk.utils.Utils.matchContentType(contentType, "application/json")) {
                ObjectMapper mapper = JSON.getMapper();
                fabra.io.javasdk.models.shared.CreateLinkTokenResponse out = mapper.readValue(new String(httpRes.body(), StandardCharsets.UTF_8), fabra.io.javasdk.models.shared.CreateLinkTokenResponse.class);
                res.createLinkTokenResponse = out;
            }
        }
        else if (httpRes.statusCode() == 401) {
        }
        else if (httpRes.statusCode() == 500) {
        }

        return res;
    }
}