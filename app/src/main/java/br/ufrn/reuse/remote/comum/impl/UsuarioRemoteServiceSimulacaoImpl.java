package br.ufrn.reuse.remote.comum.impl;

import android.content.Context;

import br.ufrn.reuse.dominio.comum.Pessoa;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.remote.comum.UsuarioRemoteService;

/**
 * Created by Daniel on 11/5/2017.
 */

public class UsuarioRemoteServiceSimulacaoImpl implements UsuarioRemoteService {

    private final Context context;

    public UsuarioRemoteServiceSimulacaoImpl(Context context) {
        this.context = context;
    }

    @Override
    public Usuario findUsuarioById(Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Teste");

        usuario.setPessoa(pessoa);

        return usuario;
    }
}
