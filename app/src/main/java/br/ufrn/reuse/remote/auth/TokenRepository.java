package br.ufrn.reuse.remote.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import br.ufrn.reuse.utils.SharedPreferencesUtils;

/**
 * Created by Daniel on 12/6/2017.
 */
public class TokenRepository {

    public static final String SHARED_PREFERENCES_NAME = "AuthPreferences";

    public static final String TOKEN_KEY = "token";
    public static final String AUTH_CODE_KEY = "authCode";

    private Context context;

    public static TokenRepository createTokenRepository(Context context){
        return new TokenRepository(context);
    }

    private TokenRepository(Context context) {
        this.context = context;
    }

    public void putToken(String token) {
        putString(TOKEN_KEY,token);
    }

    public void putAuthorizationCode(String authorizationCode) {
        putString(AUTH_CODE_KEY, authorizationCode);
    }

    public String getToken() {
        return getString(TOKEN_KEY);
    }

    public String getAuthorizationCode() {
        return getString(AUTH_CODE_KEY);
    }

    //metodos in-utils

    @NonNull
    private String getString(String key) {
        SharedPreferences preferences = SharedPreferencesUtils.getPreferences(SHARED_PREFERENCES_NAME, context);
        return preferences.getString(key,"");
    }

    private void putString(String key, String token) {
        SharedPreferences.Editor editor = SharedPreferencesUtils.getPreferences(SHARED_PREFERENCES_NAME, context).edit();
        editor.putString(key, token);
        editor.apply();
    }

}
