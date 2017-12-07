package br.ufrn.reuse.remote.patrimonio;

import android.content.Context;

import java.io.IOException;

import br.ufrn.reuse.dominio.comum.Unidade;
import br.ufrn.reuse.dominio.patrimonio.Bem;
import br.ufrn.reuse.remote.DTO.BemDTO;
import br.ufrn.reuse.remote.auth.TokenRepository;
import br.ufrn.reuse.remote.rest.ApiConfig;
import br.ufrn.reuse.remote.rest.retrofit.RetrofitFactory;
import br.ufrn.reuse.repository.local.config.DataAccessException;
import br.ufrn.reuse.utils.AuthorizationUtils;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Daniel on 11/19/2017.
 */

public class BemRemoteServiceImpl implements BemRemoteService{

    private final Context context;

    /**
     * Dependência do cliente retrofit do serviço de bens da API.
     */
    private final BemClient bemClient;
    private final TokenRepository tokenRepository;

    public BemRemoteServiceImpl(Context context){
        this.context = context;
        this.bemClient = RetrofitFactory.getOAuth2Client(BemClient.class);
        this.tokenRepository = TokenRepository.createTokenRepository(context);
    }

    @Override
    public Bem findBemById(Long idBem) {

        Call<BemDTO> findBemCall = bemClient.findBemById(AuthorizationUtils.getAuthroizationBearer(tokenRepository.getToken()), ApiConfig.getApiKey(),idBem);

        try {
            Response<BemDTO> execute = findBemCall.execute();
            return toBem(execute.body());
        } catch (IOException e) {
            throw new DataAccessException("");
        }
    }

    @Override
    public Bem findByTombamento(int numTombamento) {

        Call<BemDTO[]> findBemCall = bemClient.findByTombamento(AuthorizationUtils.getAuthroizationBearer(tokenRepository.getToken()), ApiConfig.getApiKey(),numTombamento);

        try {
            BemDTO[] bemDTOs = findBemCall.execute().body();

            if(bemDTOs != null && bemDTOs.length > 0){
                return toBem(bemDTOs[0]);
            }

            return null;

        } catch (IOException e) {
            throw new DataAccessException("");
        }
    }

    private Bem toBem(BemDTO bemDTO) {
        Bem bem = null;

        if(bemDTO != null){
            bem = new Bem();

            bem.setId(Long.valueOf(bemDTO.getIdBem()));
            bem.setDenominacao(bemDTO.getDenominacaoBem());
            bem.setNumTombamento(bemDTO.getNumeroTombamento());
            bem.setObservacoes(bemDTO.getObservacao());
        }

        return bem;
    }
}
