package br.ufrn.reuse.remote.comum.impl;

import android.content.Context;

import java.io.IOException;

import br.ufrn.reuse.dominio.comum.Unidade;
import br.ufrn.reuse.remote.comum.client.UnidadeClient;
import br.ufrn.reuse.remote.comum.UnidadeRemoteService;
import br.ufrn.reuse.remote.rest.retrofit.RetrofitFactory;
import br.ufrn.reuse.repository.local.config.DataAccessException;
import retrofit2.Call;

/**
 * Created by Daniel on 11/19/2017.
 */

public class UnidadeRemoteServiceImpl implements UnidadeRemoteService {

    private final Context context;
    private final UnidadeClient unidadeClient;

    public UnidadeRemoteServiceImpl(Context context){
        this.context = context;
        this.unidadeClient = RetrofitFactory.getOAuth2Client(UnidadeClient.class);
    }

    @Override
    public Unidade findUnidadeById(Long idUnidade) {
        //TODO: Fazer de forma Assincrona.
        //TODO: Recuperar quantidade de resultados.
        //TODO: Devolver paginação.
        Call<Unidade> findUnidadeCall = unidadeClient.findUnidadeById(idUnidade);

        try {
            return findUnidadeCall.execute().body();
        } catch (IOException e) {
            throw new DataAccessException("");
        }

    }
}
