package br.ufrn.reuse.remote.comum;

import android.content.Context;

import br.ufrn.reuse.dominio.comum.Pessoa;
import br.ufrn.reuse.dominio.comum.Usuario;

/**
 * Created by Daniel on 11/5/2017.
 */

public class UsuarioRemoteService {

    private final Context context;

    public UsuarioRemoteService(Context context) {
        this.context = context;
    }

    public Usuario findUsuarioById(Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Teste");

        usuario.setPessoa(pessoa);

        return usuario;
    }
}
