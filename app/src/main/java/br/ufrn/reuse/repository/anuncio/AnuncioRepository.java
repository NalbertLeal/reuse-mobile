package br.ufrn.reuse.repository.anuncio;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.remote.AnuncioRemoteService;
import br.ufrn.reuse.repository.patrimonio.BemRepository;
import br.ufrn.reuse.repository.comum.UnidadeRepository;
import br.ufrn.reuse.repository.comum.UsuarioRepository;
import br.ufrn.reuse.repository.anuncio.local.AnuncioLocalRepository;

/**
 * Created by nalbertg on 26/10/17.
 */

public class AnuncioRepository {

    private AnuncioRemoteService remoteService;
    private AnuncioLocalRepository localRepository;
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

    public List<Anuncio> findAll(Usuario usuario) {

        List<Anuncio> anuncios = remoteService.findAll(usuario);

        for (Anuncio anuncio : anuncios){
            anuncio.setBem(bemRepository.findBemById(anuncio.getBem().getId()));
            anuncio.setUsuario(usuarioRepository.findUsuarioById(anuncio.getUsuario().getId()));
            anuncio.setStatusAnuncio(statusAnuncioRepository.findStatusAnuncioById(anuncio.getStatusAnuncio().getIdentificador()));
            anuncio.setInteresses(interesseRepository.findInteressesByIdAnuncio(anuncio.getId()));
            anuncio.setHistoricos(historicoAnuncioRepository.findAllHistoricosByAnuncioId(anuncio.getId()));
            anuncio.setEtiquetas(etiquetaRepository.findAllEtiquetasByAnuncioId(anuncio.getId()));
            anuncio.setFotos(fotoRepository.findAllFotosByAnuncioId(anuncio.getId()));
            anuncio.setCategoria(categoriaRepository.findAllEtiquetasByAnuncioId(anuncio.getId()));
            anuncio.setUnidade(unidadeRepository.findUnidadeById(anuncio.getUnidade()));
        }

        return anuncios;
    }
}
