package br.ufrn.reuse.remote.patrimonio;

import android.content.Context;

import java.io.IOException;

import br.ufrn.reuse.dominio.patrimonio.Bem;
import br.ufrn.reuse.remote.rest.retrofit.RetrofitFactory;
import br.ufrn.reuse.repository.local.config.DataAccessException;
import retrofit2.Call;

/**
 * Created by Daniel on 11/19/2017.
 */

public class BemRemoteServiceImpl implements BemRemoteService{

    private final Context context;

    /**
     * Dependência do cliente retrofit do serviço de bens da API.
     */
    private final BemClient bemClient;

    public BemRemoteServiceImpl(Context context){
        this.context = context;
        this.bemClient = RetrofitFactory.getOAuth2Client(BemClient.class);
    }

    @Override
    public Bem findBemById(Long idBem) {
        //TODO: Fazer de forma Assincrona.
        //TODO: Recuperar quantidade de resultados.
        //TODO: Devolver paginação.
        Call<Bem> findBemCall = bemClient.findBemById(idBem);

        try {
            return findBemCall.execute().body();
        } catch (IOException e) {
            throw new DataAccessException("");
        }
    }

    @Override
    public Bem findByTombamento(int numTombamento) {
        //TODO: Fazer de forma Assincrona.
        //TODO: Recuperar quantidade de resultados.
        //TODO: Devolver paginação.
        Call<Bem> findBemCall = bemClient.findByTombamento(numTombamento);

        try {
            return findBemCall.execute().body();
        } catch (IOException e) {
            throw new DataAccessException("");
        }
    }
}
