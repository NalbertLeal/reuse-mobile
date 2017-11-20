package br.ufrn.reuse.remote.comum.impl;

import android.content.Context;

import java.io.IOException;

import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.remote.comum.UsuarioRemoteService;
import br.ufrn.reuse.remote.comum.client.UsuarioClient;
import br.ufrn.reuse.remote.rest.retrofit.RetrofitFactory;
import br.ufrn.reuse.repository.local.config.DataAccessException;
import retrofit2.Call;

/**
 * Created by Daniel on 11/19/2017.
 */

public class UsuarioRemoteServiceImpl implements UsuarioRemoteService {


    private final UsuarioClient usuarioClient;
    private final Context context;

    public UsuarioRemoteServiceImpl(Context context) {
        this.context = context;
        this.usuarioClient = RetrofitFactory.getOAuth2Client(UsuarioClient.class);
    }

    @Override
    public Usuario findUsuarioById(Long id) {
        //TODO: Fazer de forma Assincrona.
        //TODO: Recuperar quantidade de resultados.
        //TODO: Devolver paginação.
        Call<Usuario> findUsuarioCall = usuarioClient.findUsuarioById(id);

        try {
            return findUsuarioCall.execute().body();
        } catch (IOException e) {
            throw new DataAccessException("");
        }
    }
}
