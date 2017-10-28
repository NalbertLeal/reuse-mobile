package br.ufrn.reuse.repository.patrimonio;

import java.util.concurrent.Future;

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
    private BemRemoteService bemRemote;

    /**
     * Dependencia da implementação do repositório local.
     */
    private BemLocalRepository bemLocalRepository;

    public Bem findBemById(Long idBem){
        Bem bem = bemLocalRepository.findBemById(idBem);

        if(bem != null && SincronizacaoUtils.isSincronizado(bem.getDataSincronizacao(),QUANTIDADE_DIAS_SINCRONIZADO_BEM)){
            bem = bemRemote.findBemById(idBem);
            bemLocalRepository.save(bem);
        }

        return bem;

    }

}
