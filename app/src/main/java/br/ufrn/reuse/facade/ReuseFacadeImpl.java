package br.ufrn.reuse.facade;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.repository.anuncio.AnuncioRepository;
import br.ufrn.reuse.repository.patrimonio.BemRepository;
import br.ufrn.reuse.repository.anuncio.CategoriaRepository;
import br.ufrn.reuse.repository.anuncio.EtiquetaRepository;
import br.ufrn.reuse.repository.anuncio.FotoRepository;
import br.ufrn.reuse.repository.anuncio.HistoricoAnuncioRepository;
import br.ufrn.reuse.repository.anuncio.InteresseRepository;
import br.ufrn.reuse.repository.anuncio.StatusAnuncioRepository;
import br.ufrn.reuse.repository.comum.UnidadeRepository;
import br.ufrn.reuse.repository.comum.UsuarioRepository;

/**
 * Created by nalbertg on 26/10/17.
 */

public class ReuseFacadeImpl implements ReuseFacade {

    private AnuncioRepository anuncioRepository;
    private BemRepository bemRepository;
    private UsuarioRepository usuarioRepository;
    private StatusAnuncioRepository statusAnuncioRepository;
    private InteresseRepository interesseRepository;
    private HistoricoAnuncioRepository historicoAnuncioRepository;
    private EtiquetaRepository etiquetaRepository;
    private FotoRepository fotoRepository;
    private CategoriaRepository categoriaRepository;
    private UnidadeRepository unidadeRepository;

    @Override
    public List<Anuncio> findAllAnuncios(Usuario usuario) {
        return anuncioRepository.findAll(usuario);
    }
}
