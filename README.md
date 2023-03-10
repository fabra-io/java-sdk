# Fabra Java SDK

<div align="left">
   <p>Use the Fabra API to build customer-facing data warehouse integrations to let your customers start sending data to your application. Unblock your sales pipeline in days, not months.</p>
   <a href="https://github.com/fabra-io/java-sdk/actions"><img src="https://img.shields.io/github/actions/workflow/status/fabra-io/java-sdk/speakeasy_sdk_generation.yml?style=for-the-badge" /></a>
   <a href="https://www.fabra.io/#Email-Hero"><img src="https://img.shields.io/static/v1?label=Docs&message=Sign Up&color=2ca47c&style=for-the-badge" /></a>
</div>

<!-- Start SDK Installation -->
## SDK Installation

### Gradle

```groovy
implementation 'fabra.io.javasdk:fabra-java-sdk:0.3.0'
```
<!-- End SDK Installation -->

## SDK Example Usage
<!-- Start SDK Example Usage -->
```java
package hello.world;

import fabra.io.javasdk.Fabra;
import fabra.io.javasdk.models.shared.Security;

public class Application {
    public static void main(String[] args) {
        try {
            Fabra.Builder builder = Fabra.builder();

            builder.setSecurity(
                new Security() {{
                    apiKeyAuth = new SchemeAPIKeyAuth() {{
                        apiKey = "YOUR_API_KEY_HERE";
                    }};
                }}
            );

            Fabra sdk = builder.build();

            GetNamespacesRequest req = new GetNamespacesRequest() {{
                queryParams = new GetNamespacesQueryParams() {{
                    connectionID = 548814;
                }};
            }};

            GetNamespacesResponse res = sdk.connection.getNamespaces(req);

            if (res.getNamespaces200ApplicationJSONObject.isPresent()) {
                // handle response
            }
        } catch (Exception e) {
            // handle exception
        }
```
<!-- End SDK Example Usage -->

<!-- Start SDK Available Operations -->
## SDK Available Operations


### connection

* `getNamespaces` - Get all namespaces
* `getSchema` - Get schema for table
* `getTables` - Get all tables

### destination

* `createDestination` - Create a new destination
* `getDestinations` - Get all destinations

### linkToken

* `createLinkToken` - Create a new link token

### object

* `createObject` - Create a new object
* `getObjects` - Get all objects

### source

* `createSource` - Create a new source
* `getSources` - Get all sources

### sync

* `createSync` - Create a new sync
* `getSyncs` - Get all syncs
<!-- End SDK Available Operations -->

### SDK Generated by [Speakeasy](https://docs.speakeasyapi.dev/docs/using-speakeasy/client-sdks)
