package br.ufrn.reuse.remote.patrimonio;

import br.ufrn.reuse.dominio.patrimonio.Bem;

/**
 * Created by Daniel on 11/19/2017.
 */

public interface BemRemoteService {
    Bem findBemById(Long idBem);

    Bem findByTombamento(int numTombamento);
}
