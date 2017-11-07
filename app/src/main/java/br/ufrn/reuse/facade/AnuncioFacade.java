package br.ufrn.reuse.facade;

import android.content.Context;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;
import br.ufrn.reuse.dominio.anuncio.Etiqueta;
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
 * Fachada para o módulo de anúncios.
 *
 * @author Daniel
 */
class AnuncioFacade {

    private AnuncioRepository anuncioRepository;
    private BemRepository bemRepository;
    private UsuarioRepository usuarioRepository;
    private StatusAnuncioRepository statusAnuncioRepository;
    private InteresseRepository interesseRepository;
    private HistoricoAnuncioRepository historicoAnuncioRepository;
    private EtiquetaRepository etiquetaRepository;
    private FotoRepository fotoRepository;
    CategoriaRepository categoriaRepository;
    private UnidadeRepository unidadeRepository;

    public AnuncioFacade(Context context){
        this.anuncioRepository = new AnuncioRepository(context);
        this.bemRepository = new BemRepository(context);
        this.usuarioRepository = new UsuarioRepository(context);
        this.statusAnuncioRepository = new StatusAnuncioRepository(context);
        this.interesseRepository = new InteresseRepository(context);
        this.historicoAnuncioRepository = new HistoricoAnuncioRepository(context);
        this.etiquetaRepository = new EtiquetaRepository(context);
        this.fotoRepository = new FotoRepository(context);
        this.categoriaRepository = new CategoriaRepository(context);
        this.unidadeRepository = new UnidadeRepository(context);
    }


    public Anuncio cadastrar(Anuncio anuncio){
        //TODO: VALIDAR
        return anuncioRepository.cadastrar(anuncio);
    }


    public List<Anuncio> findAllAnuncios(Usuario usuario) {
        List<Anuncio> anuncios = anuncioRepository.findAll(usuario);

        loadAnuncios(anuncios);

        return anuncios;
    }

    public Anuncio findAnuncioById(Long idAnuncio){

        Anuncio anuncio = anuncioRepository.findAnuncioById(idAnuncio);

        loadAnuncio(anuncio);

        return anuncio;
    }

    public List<Anuncio> findAllAnunciosPublicados() {
        List<Anuncio> anuncios = anuncioRepository.findAllAnunciosPublicados();

        loadAnuncios(anuncios);

        return anuncios;
    }

    public List<Anuncio> findAllAnuncios(CategoriaAnuncio categoria, String denominacaoBem, Integer numeroTombamento, List<Etiqueta> etiquetas) {
        return anuncioRepository.findAllAnuncios(categoria,denominacaoBem,numeroTombamento,etiquetas);
    }



    /**
     * Busca todas as categorias de anúncio.
     *
     * @return
     */
    public List<CategoriaAnuncio> findAllCategorias(){
        return categoriaRepository.findAllCategorias();
    }

    /**
     * Busca os anúncios que contenham o substring.
     *
     * @param textoBusca
     * @return
     */
    public List<Anuncio> findAllAnunciosPublicados(String textoBusca) {
        return anuncioRepository.findAllAnunciosPublicados(textoBusca);
    }

    //Métodos que efetuam o join das informações.

    /**
     * Carrega as informações de uma lista de anúncios.
     *
     * @param anuncios
     */
    private void loadAnuncios(List<Anuncio> anuncios) {
        for(Anuncio anuncio : anuncios){
            loadAnuncio(anuncio);
        }
    }

    public List<Etiqueta> findAllEtiquetas() {
        return etiquetaRepository.findAllEtiquetas();
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
            anuncio.setCategoria(categoriaRepository.findCategoriaById(anuncio.getCategoria().getIdentificador()));
            anuncio.setUnidade(unidadeRepository.findUnidadeById(anuncio.getUnidade().getId()));
        }

    }

}
