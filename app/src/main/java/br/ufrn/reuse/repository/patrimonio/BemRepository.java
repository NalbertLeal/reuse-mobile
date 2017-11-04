package br.ufrn.reuse.repository.patrimonio;

import android.content.Context;
import android.support.annotation.NonNull;

import br.ufrn.reuse.dominio.patrimonio.Bem;
import br.ufrn.reuse.remote.BemRemoteService;
import br.ufrn.reuse.repository.patrimonio.local.BemLocalRepository;
import br.ufrn.reuse.utils.SincronizacaoUtils;

/**
 * Classe que representa o repositório de bens do reuse.
 */

public class BemRepository {

    /**
     * Quantidade de dias que um bem será considerado atualizado no banco local.
     */
    public static final int QUANTIDADE_DIAS_SINCRONIZADO_BEM = 2;


    /**
     * Dependencia da implementação do serviço remoto.
     */
    public BemRemoteService bemRemote;

    /**
     * Dependencia da implementação do repositório local.
     */
    private BemLocalRepository bemLocalRepository;

    private final Context context;

    public BemRepository(Context context) {
        this.context = context;
    }

    public Bem findBemById(Long idBem){
        Bem bem = bemLocalRepository.findBemById(idBem);

        if(bem != null && SincronizacaoUtils.isSincronizado(bem.getDataSincronizacao(),QUANTIDADE_DIAS_SINCRONIZADO_BEM)){
            bem = bemRemote.findBemById(idBem);
            bemLocalRepository.save(bem);
        }

        return bem;

    }

    public Bem findByTombamento(int numTombamento){
        return bemRemote.findByTombamento(numTombamento);
    }
}
