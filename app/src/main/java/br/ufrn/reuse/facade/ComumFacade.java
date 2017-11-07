package br.ufrn.reuse.facade;

import android.content.Context;

import br.ufrn.reuse.dominio.comum.Pessoa;
import br.ufrn.reuse.dominio.comum.Unidade;
import br.ufrn.reuse.dominio.comum.Usuario;

/**
 * Created by Daniel on 11/3/2017.
 */

public class ComumFacade {

    public ComumFacade(Context context) {

    }

    /**
     * Popula o usuario apenas o ID
     * @param usuario
     * @param senha
     * @return
     */
    public Usuario autenticar(String usuario, String senha) {
        Usuario user = new Usuario(5);
        return user; //new ComumRemoteService().credenciaisValidas(usuario, senha);
    }

    public Usuario findUsuarioById(Long idUsuario) {
        Usuario user = new Usuario(5);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Apuena");
        user.setPessoa(pessoa);
        Unidade unidade = new Unidade();
        unidade.setSigla("IMD");
        user.getUnidadesUsuario().add(unidade);
        return user; //new ComumRemoteService().findUsuarioById(usuario);
    }
}
