package br.ufrn.reuse.remote.comum.client;

import br.ufrn.reuse.remote.DTO.UsuarioDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by Daniel on 11/19/2017.
 */

public interface UsuarioClient {

    @GET("/usuario/v0.1/usuarios/{idUsuario}")
    Call<UsuarioDTO> findUsuarioById(@Header("Authorization") String authentication, @Header("x-api-key") String apiKey, @Path("idUsuario") long idUsuario);

    @GET("/usuario/v0.1/usuarios/info")
    Call<UsuarioDTO> findUsuarioLogado(@Header("Authorization") String authentication, @Header("x-api-key") String apiKey);

}
