package br.ufrn.reuse.remote.rest;

/**
 * Created by Daniel on 11/15/2017.
 */

public class ApiConfig {
    public static String getApiKey() {
        return null;
    }

    public static String getClientId() {
        return null;
    }

    public static String getClientSecret() {
        return null;
    }

    public static String getAuthUrl() {
        return null;
    }

    public static String getBaseUrl(){
        return null;
    }

    public static String getGrantType() {
        return null;
    }

    public static ClientDetails getClientDetails(){
        return new ClientDetails(getClientId(),getClientSecret(),getGrantType(),getApiKey());

    }
}
