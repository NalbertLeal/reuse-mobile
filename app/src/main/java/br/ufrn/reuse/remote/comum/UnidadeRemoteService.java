package br.ufrn.reuse.remote.comum;

import br.ufrn.reuse.dominio.comum.Unidade;

/**
 * Created by Daniel on 11/19/2017.
 */

public interface UnidadeRemoteService {
    Unidade findUnidadeById(Long idUnidade);
}
