package br.ufrn.reuse.remote.comum.client;

import br.ufrn.reuse.dominio.comum.Usuario;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Daniel on 11/19/2017.
 */

public interface UsuarioClient {

    @GET("/usuario/v0.1/usuarios/{idUsuario}")
    Call<Usuario> findUsuarioById(@Path("idUsuario") long idUsuario);

}
