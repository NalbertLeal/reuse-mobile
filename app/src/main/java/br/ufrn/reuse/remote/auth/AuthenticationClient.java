package br.ufrn.reuse.remote.auth;

import br.ufrn.reuse.remote.DTO.AuthorizationDTO;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Cliente para a autorização (OAuth2)
 *
 * @author Daniel
 *
 */

public interface AuthenticationClient {

    @POST(value = "/authz-server/oauth/token")
    public Call<AuthorizationDTO> authorize(@Header("x-api-key") String apiKey,
                                            @Query("client_secret") String clientSecret,
                                            @Query("client_id") String clientId,
                                            @Query("grant_type") String grantType);




}
