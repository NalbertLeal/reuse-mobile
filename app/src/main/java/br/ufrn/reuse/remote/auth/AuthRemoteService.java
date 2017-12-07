package br.ufrn.reuse.remote.auth;

import br.ufrn.reuse.remote.rest.ApiConfig;
import br.ufrn.reuse.remote.DTO.AuthorizationDTO;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by Daniel on 11/19/2017.
 */
public class AuthRemoteService {

    public Call<AuthorizationDTO> authorize(){
        AuthenticationClient authenticationClient = new Retrofit.Builder()
                .baseUrl(ApiConfig.getBaseUrl())
                .build()
                .create(AuthenticationClient.class);

        Call<AuthorizationDTO> authorizationCall = authenticationClient.authorize(ApiConfig.getApiKey(), ApiConfig.getClientSecret(), ApiConfig.getClientId(), ApiConfig.getGrantType());

        return authorizationCall;
    }

}
