package br.ufrn.reuse.facade;

import android.content.Context;

import br.ufrn.reuse.dominio.comum.Pessoa;
import br.ufrn.reuse.dominio.comum.Unidade;
import br.ufrn.reuse.dominio.comum.Usuario;

/**
 * Created by Daniel on 11/3/2017.
 */

public class ComumFacade {

    private final Context context;

    public ComumFacade(Context context) {
        this.context = context;
    }

    /**
     * Popula o usuario apenas o ID
     * @param usuario
     * @param senha
     * @return
     */
    public Usuario autenticar(String usuario, String senha) {
        return findUsuarioById(5L); //new ComumRemoteService().credenciaisValidas(usuario, senha);
    }

    public Usuario findUsuarioById(Long idUsuario) {
        return new Usuario(5L,"apuena", new Unidade("IMD"), new Pessoa("Apuena")); //new ComumRemoteService().findUsuarioById(usuario);
    }

}
