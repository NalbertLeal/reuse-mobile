package br.ufrn.reuse.repository.comum;

import android.content.Context;

import br.ufrn.reuse.dominio.comum.Usuario;

/**
 * Created by Daniel on 10/27/2017.
 */

public class UsuarioRepository {
    private final Context context;

    public UsuarioRepository(Context context) {
        this.context = context;
    }

    public Usuario findUsuarioById(Long id) {
        return null;
    }
}
