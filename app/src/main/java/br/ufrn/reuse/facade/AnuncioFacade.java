package br.ufrn.reuse.facade;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.comum.Usuario;

import br.ufrn.reuse.repository.anuncio.AnuncioRepository;
import br.ufrn.reuse.repository.anuncio.CategoriaRepository;
import br.ufrn.reuse.repository.anuncio.EtiquetaRepository;
import br.ufrn.reuse.repository.anuncio.FotoRepository;
import br.ufrn.reuse.repository.anuncio.HistoricoAnuncioRepository;
import br.ufrn.reuse.repository.anuncio.InteresseRepository;
import br.ufrn.reuse.repository.anuncio.StatusAnuncioRepository;

import br.ufrn.reuse.repository.comum.UnidadeRepository;
import br.ufrn.reuse.repository.comum.UsuarioRepository;
import br.ufrn.reuse.repository.patrimonio.BemRepository;

/**
 * Created by Daniel on 10/27/2017.
 */
public class AnuncioFacade {

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

    public Anuncio cadastrar(Anuncio anuncio){
        //TODO: VALIDAR
        return anuncioRepository.cadastrar(anuncio);
    }


    public List<Anuncio> findAllAnuncios(Usuario usuario) {
        List<Anuncio> anuncios = anuncioRepository.findAll(usuario);

        for (Anuncio anuncio : anuncios){
            loadAnuncio(anuncio);
        }

        return anuncios;
    }

    public Anuncio findAnuncioById(Long idAnuncio){

        Anuncio anuncio = anuncioRepository.findAnuncioById(idAnuncio);

        loadAnuncio(anuncio);

        return anuncio;
    }

    /**
     * Efetua o """"""Join""""" dos """"""relacionamentos"""""
     *
     * @param anuncio
     */
    private void loadAnuncio(Anuncio anuncio) {

        if(anuncio != null){
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

    }

}
