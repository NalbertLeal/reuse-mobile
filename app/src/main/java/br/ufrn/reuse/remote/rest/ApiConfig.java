package br.ufrn.reuse.remote.rest;

/**
 * Created by Daniel on 11/15/2017.
 */

public class ApiConfig {


    /*CONSTANT FOR THE AUTHORIZATION PROCESS*/

    /****FILL THIS WITH YOUR INFORMATION*********/

    //This is any string we want to use. This will be used for avoid CSRF attacks. You can generate one here: http://strongpasswordgenerator.com/
    public static final String STATE = "E3ZYKC1T6H2yP4z";
    //This is the url that LinkedIn Auth process will redirect to. We can put whatever we want that starts with http:// or https:// .
    //We use a made up url that we will intercept when redirecting. Avoid Uppercases.
    public static final String REDIRECT_URI = "https://api.ufrn.br";
    /*********************************************/

    //These are constants used for build the urls
    public static final String AUTHORIZATION_URL = "https://apitestes.info.ufrn.br/authz-server/oauth/authorize";
    public static final String ACCESS_TOKEN_URL = "https://apitestes.info.ufrn.br/authz-server/oauth/token";
    public static final String SECRET_KEY_PARAM = "client_secret";
    public static final String RESPONSE_TYPE_PARAM = "response_type";
    public static final String GRANT_TYPE_PARAM = "grant_type";
    public static final String GRANT_TYPE = "authorization_code";
    public static final String RESPONSE_TYPE_VALUE = "code";
    public static final String CLIENT_ID_PARAM = "client_id";
    public static final String STATE_PARAM = "state";
    public static final String REDIRECT_URI_PARAM = "redirect_uri";
    /*---------------------------------------*/
    public static final String QUESTION_MARK = "?";
    public static final String AMPERSAND = "&";
    public static final String EQUALS = "=";

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
        return GRANT_TYPE;
    }


    /**
     * Method that generates the url for get the access token from the Service
     *
     * @return Url
     */
    public static String getAccessTokenUrl(String authorizationToken) {
        return ACCESS_TOKEN_URL
                + QUESTION_MARK
                + GRANT_TYPE_PARAM + EQUALS + GRANT_TYPE
                + AMPERSAND
                + RESPONSE_TYPE_VALUE + EQUALS + authorizationToken
                + AMPERSAND
                + CLIENT_ID_PARAM + EQUALS + getClientId()
                + AMPERSAND
                + REDIRECT_URI_PARAM + EQUALS + REDIRECT_URI
                + AMPERSAND
                + SECRET_KEY_PARAM + EQUALS + getClientSecret();
    }

    /**
     * Method that generates the url for get the authorization token from the Service
     *
     * @return Url
     */
    public static String getAuthorizationUrl() {
        return AUTHORIZATION_URL
                + QUESTION_MARK + RESPONSE_TYPE_PARAM + EQUALS + RESPONSE_TYPE_VALUE
                + AMPERSAND + CLIENT_ID_PARAM + EQUALS + getClientId()
                + AMPERSAND + STATE_PARAM + EQUALS + STATE
                + AMPERSAND + REDIRECT_URI_PARAM + EQUALS + REDIRECT_URI;
    }

    public static ClientDetails getClientDetails(){
        return new ClientDetails(getClientId(),getClientSecret(),getGrantType(),getApiKey());
    }

}
