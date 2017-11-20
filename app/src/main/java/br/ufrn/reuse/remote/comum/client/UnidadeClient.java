package br.ufrn.reuse.remote.comum.client;

import br.ufrn.reuse.dominio.comum.Unidade;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Daniel on 11/19/2017.
 */

public interface UnidadeClient {

    @GET("/unidade/v0.1/unidades/{idUnidade}")
    Call<Unidade> findUnidadeById(@Path("idUnidade") long idUnidade);
}
