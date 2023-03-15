package fabra.io.javasdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import fabra.io.javasdk.utils.HTTPClient;
import fabra.io.javasdk.utils.HTTPRequest;
import fabra.io.javasdk.utils.JSON;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import org.apache.http.NameValuePair;

public class Connection {
	
	private HTTPClient _defaultClient;
	private HTTPClient _securityClient;
	private String _serverUrl;
	private String _language;
	private String _sdkVersion;
	private String _genVersion;

	public Connection(HTTPClient defaultClient, HTTPClient securityClient, String serverUrl, String language, String sdkVersion, String genVersion) {
		this._defaultClient = defaultClient;
		this._securityClient = securityClient;
		this._serverUrl = serverUrl;
		this._language = language;
		this._sdkVersion = sdkVersion;
		this._genVersion = genVersion;
	}
	
    
    /**
     * getNamespaces - Get all namespaces
    **/
    public fabra.io.javasdk.models.operations.GetNamespacesResponse getNamespaces(fabra.io.javasdk.models.operations.GetNamespacesRequest request) throws Exception {
        String baseUrl = this._serverUrl;
        String url = fabra.io.javasdk.utils.Utils.generateURL(baseUrl, "/connection/namespaces");
        
        HTTPRequest req = new HTTPRequest();
        req.setMethod("GET");
        req.setURL(url);
        
        java.util.List<NameValuePair> queryParams = fabra.io.javasdk.utils.Utils.getQueryParams(fabra.io.javasdk.models.operations.GetNamespacesQueryParams.class, request.queryParams, null);
        if (queryParams != null) {
            for (NameValuePair queryParam : queryParams) {
                req.addQueryParam(queryParam);
            }
        }
        
        HTTPClient client = this._securityClient;
        
        HttpResponse<byte[]> httpRes = client.send(req);

        String contentType = httpRes.headers().firstValue("Content-Type").orElse("application/octet-stream");

        fabra.io.javasdk.models.operations.GetNamespacesResponse res = new fabra.io.javasdk.models.operations.GetNamespacesResponse() {{
            getNamespaces200ApplicationJSONObject = null;
        }};
        res.statusCode = httpRes.statusCode();
        res.contentType = contentType;
        res.rawResponse = httpRes;
        
        if (httpRes.statusCode() == 200) {
            if (fabra.io.javasdk.utils.Utils.matchContentType(contentType, "application/json")) {
                ObjectMapper mapper = JSON.getMapper();
                fabra.io.javasdk.models.operations.GetNamespaces200ApplicationJSON out = mapper.readValue(new String(httpRes.body(), StandardCharsets.UTF_8), fabra.io.javasdk.models.operations.GetNamespaces200ApplicationJSON.class);
                res.getNamespaces200ApplicationJSONObject = out;
            }
        }
        else if (httpRes.statusCode() == 401 || httpRes.statusCode() == 500) {
        }

        return res;
    }
	
    
    /**
     * getSchema - Get schema for table
    **/
    public fabra.io.javasdk.models.operations.GetSchemaResponse getSchema(fabra.io.javasdk.models.operations.GetSchemaRequest request) throws Exception {
        String baseUrl = this._serverUrl;
        String url = fabra.io.javasdk.utils.Utils.generateURL(baseUrl, "/connection/schema");
        
        HTTPRequest req = new HTTPRequest();
        req.setMethod("GET");
        req.setURL(url);
        
        java.util.List<NameValuePair> queryParams = fabra.io.javasdk.utils.Utils.getQueryParams(fabra.io.javasdk.models.operations.GetSchemaQueryParams.class, request.queryParams, null);
        if (queryParams != null) {
            for (NameValuePair queryParam : queryParams) {
                req.addQueryParam(queryParam);
            }
        }
        
        HTTPClient client = this._securityClient;
        
        HttpResponse<byte[]> httpRes = client.send(req);

        String contentType = httpRes.headers().firstValue("Content-Type").orElse("application/octet-stream");

        fabra.io.javasdk.models.operations.GetSchemaResponse res = new fabra.io.javasdk.models.operations.GetSchemaResponse() {{
            getSchema200ApplicationJSONObject = null;
        }};
        res.statusCode = httpRes.statusCode();
        res.contentType = contentType;
        res.rawResponse = httpRes;
        
        if (httpRes.statusCode() == 200) {
            if (fabra.io.javasdk.utils.Utils.matchContentType(contentType, "application/json")) {
                ObjectMapper mapper = JSON.getMapper();
                fabra.io.javasdk.models.operations.GetSchema200ApplicationJSON out = mapper.readValue(new String(httpRes.body(), StandardCharsets.UTF_8), fabra.io.javasdk.models.operations.GetSchema200ApplicationJSON.class);
                res.getSchema200ApplicationJSONObject = out;
            }
        }
        else if (httpRes.statusCode() == 401 || httpRes.statusCode() == 500) {
        }

        return res;
    }
	
    
    /**
     * getTables - Get all tables
    **/
    public fabra.io.javasdk.models.operations.GetTablesResponse getTables(fabra.io.javasdk.models.operations.GetTablesRequest request) throws Exception {
        String baseUrl = this._serverUrl;
        String url = fabra.io.javasdk.utils.Utils.generateURL(baseUrl, "/connection/tables");
        
        HTTPRequest req = new HTTPRequest();
        req.setMethod("GET");
        req.setURL(url);
        
        java.util.List<NameValuePair> queryParams = fabra.io.javasdk.utils.Utils.getQueryParams(fabra.io.javasdk.models.operations.GetTablesQueryParams.class, request.queryParams, null);
        if (queryParams != null) {
            for (NameValuePair queryParam : queryParams) {
                req.addQueryParam(queryParam);
            }
        }
        
        HTTPClient client = this._securityClient;
        
        HttpResponse<byte[]> httpRes = client.send(req);

        String contentType = httpRes.headers().firstValue("Content-Type").orElse("application/octet-stream");

        fabra.io.javasdk.models.operations.GetTablesResponse res = new fabra.io.javasdk.models.operations.GetTablesResponse() {{
            getTables200ApplicationJSONObject = null;
        }};
        res.statusCode = httpRes.statusCode();
        res.contentType = contentType;
        res.rawResponse = httpRes;
        
        if (httpRes.statusCode() == 200) {
            if (fabra.io.javasdk.utils.Utils.matchContentType(contentType, "application/json")) {
                ObjectMapper mapper = JSON.getMapper();
                fabra.io.javasdk.models.operations.GetTables200ApplicationJSON out = mapper.readValue(new String(httpRes.body(), StandardCharsets.UTF_8), fabra.io.javasdk.models.operations.GetTables200ApplicationJSON.class);
                res.getTables200ApplicationJSONObject = out;
            }
        }
        else if (httpRes.statusCode() == 401 || httpRes.statusCode() == 500) {
        }

        return res;
    }
}