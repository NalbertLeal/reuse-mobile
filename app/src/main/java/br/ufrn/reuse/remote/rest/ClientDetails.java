package br.ufrn.reuse.remote.rest;

/**
 * Created by Daniel on 11/19/2017.
 */

public class ClientDetails {
    private final String  clientId;
    private final String clientSecret;
    private final String grantType;
    private final String apiKey;

    public ClientDetails(String clientId, String clientSecret, String grantType, String apiKey) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.grantType = grantType;
        this.apiKey = apiKey;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getGrantType() {
        return grantType;
    }

    public String getApiKey() {
        return apiKey;
    }
}
