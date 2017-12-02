package br.ufrn.reuse.remote.rest;

/**
 * Created by Daniel on 11/15/2017.
 */

public class ApiConfig {
    public static String getApiKey() {
        return "rmQUF0E487oFoFUMzTuiGiNTAUXspNnEo72VKH6A";
    }

    public static String getClientId() {
        return "reuse-mobile-id";
    }

    public static String getClientSecret() {
        return "segredo";
    }

    public static String getAuthUrl() {
        return getBaseUrl()+"/authz-server/ouauth/token";
    }

    public static String getBaseUrl(){ return "https://apitestes.info.ufrn.br"; }

    public static String getGrantType() {
        return "client-credentials";
    }

    public static ClientDetails getClientDetails(){
        return new ClientDetails(getClientId(),getClientSecret(),getGrantType(),getApiKey());

    }
}
