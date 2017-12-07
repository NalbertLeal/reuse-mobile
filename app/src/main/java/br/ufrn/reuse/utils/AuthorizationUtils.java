package br.ufrn.reuse.utils;

/**
 * Created by Daniel on 12/7/2017.
 */

public class AuthorizationUtils {

    public static String getAuthroizationBearer(String token){
        return "bearer "+token;
    }
}
