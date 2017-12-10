package br.ufrn.reuse.facade;

import android.content.Context;

import br.ufrn.reuse.dominio.comum.Pessoa;
import br.ufrn.reuse.dominio.comum.Unidade;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.repository.comum.UnidadeRepository;
import br.ufrn.reuse.repository.comum.UsuarioRepository;

/**
 * Created by Daniel on 11/3/2017.
 */

public class ComumFacade {

    private final Context context;
    private UsuarioRepository usuarioRepository;
    private UnidadeRepository unidadeRepository;


    public ComumFacade(Context context) {
        this.context = context;
        this.usuarioRepository = new UsuarioRepository(context);
        this.unidadeRepository = new UnidadeRepository(context);
    }

    /**
     * Popula o usuario apenas o ID
     *
     * @param usuario
     * @param senha
     * @return
     */
    public Usuario autenticar(String usuario, String senha) {
        return findUsuarioById(5L); //new ComumRemoteService().credenciaisValidas(usuario, senha);
    }

    public Usuario findUsuarioById(Long idUsuario) {
        return new Usuario(5L, "apuena", new Unidade("IMD"), new Pessoa("Apuena")); //new ComumRemoteService().findUsuarioById(usuario);
    }

    public Usuario findUsuarioLogado() {

        Usuario usuarioLogado = usuarioRepository.findUsuarioLogado();

        if(usuarioLogado != null){

            Unidade unidadeUsuario = usuarioLogado.getUnidade();

            if(unidadeUsuario != null){
                usuarioLogado.setUnidade(unidadeRepository.findUnidadeById(unidadeUsuario.getId()));
            }

        }

        return usuarioLogado;
    }

    public Unidade findUnidadeById(Long idUnidade){
        return unidadeRepository.findUnidadeById(idUnidade);
    }
}
