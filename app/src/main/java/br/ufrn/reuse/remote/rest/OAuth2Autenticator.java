package br.ufrn.reuse.remote.rest;

import android.support.annotation.Nullable;

import java.io.IOException;

import br.ufrn.reuse.remote.DTO.AuthorizationDTO;
import br.ufrn.reuse.remote.auth.AuthRemoteService;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Call;

/**
 * Created by Daniel on 11/19/2017.
 */

public class OAuth2Autenticator implements Authenticator{

    private final ClientDetails clientDetails;

    public OAuth2Autenticator(ClientDetails clientDetails){
        this.clientDetails = clientDetails;
    }

    @Nullable
    @Override
    public Request authenticate(Route route, Response response) throws IOException {

        if (response.request().header("Authorization") != null) {
            return null;
        }

        AuthRemoteService remoteService = new AuthRemoteService();
        Call<AuthorizationDTO> authorize = remoteService.authorize();

        try {
            retrofit2.Response<AuthorizationDTO> authorizationResponse = authorize.execute();

            if(authorizationResponse.code() == 200){

                AuthorizationDTO authorization = authorizationResponse.body();

                return response.request()
                        .newBuilder()
                        .header("Authorization", authorization.getAuthorizationHeader())
                        .build();

            }else{
                return null;
            }

        }catch (IOException ex){
            return null;
        }
    }
}
