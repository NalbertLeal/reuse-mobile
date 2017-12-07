package br.ufrn.reuse.remote.comum.impl;

import android.content.Context;

import java.io.IOException;

import br.ufrn.reuse.dominio.comum.Unidade;
import br.ufrn.reuse.remote.DTO.UnidadeDTO;
import br.ufrn.reuse.remote.auth.TokenRepository;
import br.ufrn.reuse.remote.comum.client.UnidadeClient;
import br.ufrn.reuse.remote.comum.UnidadeRemoteService;
import br.ufrn.reuse.remote.rest.retrofit.RetrofitFactory;
import br.ufrn.reuse.repository.local.config.DataAccessException;
import br.ufrn.reuse.utils.AuthorizationUtils;
import retrofit2.Call;

/**
 * Created by Daniel on 11/19/2017.
 */

public class UnidadeRemoteServiceImpl implements UnidadeRemoteService {

    private final Context context;
    private final UnidadeClient unidadeClient;
    private final TokenRepository tokenRepository;

    public UnidadeRemoteServiceImpl(Context context){
        this.context = context;
        this.unidadeClient = RetrofitFactory.getOAuth2Client(UnidadeClient.class);
        this.tokenRepository = TokenRepository.createTokenRepository(context);
    }

    @Override
    public Unidade findUnidadeById(Long idUnidade) {
        //TODO: Fazer de forma Assincrona.
        //TODO: Recuperar quantidade de resultados.
        //TODO: Devolver paginação.

        Call<UnidadeDTO> findUnidadeCall = unidadeClient.findUnidadeById(AuthorizationUtils.getAuthroizationBearer(tokenRepository.getToken()),idUnidade);

        try {
            UnidadeDTO unidadeDTO = findUnidadeCall.execute().body();

            Unidade unidade = toUnidade(unidadeDTO);

            return unidade;
        } catch (IOException e) {
            throw new DataAccessException("");
        }

    }

    private Unidade toUnidade(UnidadeDTO unidadeDTO) {

        Unidade unidade = null;

        if(unidadeDTO != null){
            unidade.setId(Long.valueOf(unidadeDTO.getIdUnidade()));
            unidade.setNome(unidadeDTO.getNomeUnidade());
            unidade.setCodigo(Long.valueOf(unidadeDTO.getCodigoUnidade()));
            unidade.setSigla(unidadeDTO.getSigla());
        }

        return unidade;
    }
}
