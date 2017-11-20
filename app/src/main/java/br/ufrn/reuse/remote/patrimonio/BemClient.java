package br.ufrn.reuse.remote.patrimonio;

import br.ufrn.reuse.dominio.patrimonio.Bem;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Daniel on 11/19/2017.
 */

public interface BemClient {

    @GET("/bem/v0.1/bens")
    Call<Bem> findByTombamento(@Query("numero-tombamento") int numeroTombamento);

    @GET("/bem/v0.1/bens/{idBem}")
    Call<Bem> findBemById(@Path("idBem") Long idBem);

}
