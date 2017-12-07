package br.ufrn.reuse.remote.comum;

import br.ufrn.reuse.dominio.comum.Usuario;

/**
 * Created by Daniel on 11/19/2017.
 */

public interface UsuarioRemoteService {
    Usuario findUsuarioById(Long id);
}
