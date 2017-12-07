package br.ufrn.reuse.remote.patrimonio;

import br.ufrn.reuse.dominio.patrimonio.Bem;
import br.ufrn.reuse.remote.DTO.BemDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Daniel on 11/19/2017.
 */

public interface BemClient {

    @GET("/bem/v0.1/bens")
    Call<BemDTO[]> findByTombamento(@Header("Authorization") String authentication, @Header("x-api-key") String apiKey, @Query("numero-tombamento") int numeroTombamento);

    @GET("/bem/v0.1/bens/{idBem}")
    Call<BemDTO> findBemById(@Header("Authorization") String authentication, @Header("x-api-key") String apiKey, @Path("idBem") Long idBem);

}
