package br.ufrn.reuse.remote.comum.impl;

import android.content.Context;

import java.io.IOException;

import br.ufrn.reuse.dominio.comum.Pessoa;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.remote.DTO.UsuarioDTO;
import br.ufrn.reuse.remote.auth.TokenRepository;
import br.ufrn.reuse.remote.comum.UsuarioRemoteService;
import br.ufrn.reuse.remote.comum.client.UsuarioClient;
import br.ufrn.reuse.remote.rest.ApiConfig;
import br.ufrn.reuse.remote.rest.retrofit.RetrofitFactory;
import br.ufrn.reuse.repository.local.config.DataAccessException;
import br.ufrn.reuse.utils.AuthorizationUtils;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Daniel on 11/19/2017.
 */

public class UsuarioRemoteServiceImpl implements UsuarioRemoteService {


    private final UsuarioClient usuarioClient;
    private final Context context;
    private final TokenRepository tokenRepository;

    public UsuarioRemoteServiceImpl(Context context) {
        this.context = context;
        this.usuarioClient = RetrofitFactory.getOAuth2Client(UsuarioClient.class);
        this.tokenRepository = TokenRepository.createTokenRepository(context);
    }

    @Override
    public Usuario findUsuarioById(Long id) {
        //TODO: Fazer de forma Assincrona.
        //TODO: Recuperar quantidade de resultados.
        //TODO: Devolver paginação.
        Call<UsuarioDTO> findUsuarioCall = usuarioClient.findUsuarioById(AuthorizationUtils.getAuthroizationBearer(tokenRepository.getToken()), ApiConfig.getApiKey(),id);

        try {
            Response<UsuarioDTO> execute = findUsuarioCall.execute();
            return toUsuario(execute.body());
        } catch (IOException e) {
            throw new DataAccessException("");
        }
    }

    private Usuario toUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = null;

        if(usuarioDTO != null && usuarioDTO.getIdUsuario() > 0){
            usuario = new Usuario();

            usuario.setId(Long.valueOf(usuarioDTO.getIdUsuario()));

            if(usuarioDTO.getCpfCnpj() != null) {
                usuario.setPessoa(new Pessoa(usuarioDTO.getNomePessoa(),String.valueOf(usuarioDTO.getCpfCnpj())));
            }

            usuario.setEmail(usuarioDTO.getEmail());
            usuario.setLogin(usuarioDTO.getLogin());

        }

        return usuario;
    }
}
