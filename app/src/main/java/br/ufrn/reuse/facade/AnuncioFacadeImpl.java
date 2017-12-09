package br.ufrn.reuse.facade;

import android.content.Context;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;
import br.ufrn.reuse.dominio.anuncio.Etiqueta;
import br.ufrn.reuse.dominio.comum.Usuario;

import br.ufrn.reuse.remote.anuncio.AnuncioRemoteService;
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
class AnuncioFacadeImpl implements AnuncioFacade {

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

    public AnuncioFacadeImpl(Context context){
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

    /**
     *
     * Cadastra um anúncio
     *
     * @param anuncio
     * @return
     */
    @Override
    public Anuncio cadastrar(Anuncio anuncio){
        Anuncio anuncioCadastrado = anuncioRepository.cadastrar(anuncio);

        loadAnuncio(anuncioCadastrado);

        return anuncioCadastrado;
    }


    @Override
    public List<Anuncio> findAllAnuncios(Usuario usuario) {
        List<Anuncio> anuncios = anuncioRepository.findAll(usuario);

        loadAnuncios(anuncios);

        return anuncios;
    }

    @Override
    public Anuncio findAnuncioById(Long idAnuncio){

        Anuncio anuncio = anuncioRepository.findAnuncioById(idAnuncio);

        loadAnuncio(anuncio);

        return anuncio;
    }

    /**
     * Retorna todos os anúncios publicados
     *
     * @return
     */
    @Override
    public List<Anuncio> findAllAnunciosPublicados() {
        List<Anuncio> anuncios = anuncioRepository.findAllAnunciosPublicados();

        loadAnuncios(anuncios);

        return anuncios;
    }

    @Override
    public List<Anuncio> findAllAnuncios(CategoriaAnuncio categoria, String denominacaoBem, Integer numeroTombamento, List<Etiqueta> etiquetas) {
        List<Anuncio> anuncios = anuncioRepository.findAllAnuncios(categoria, denominacaoBem, numeroTombamento, etiquetas);

        loadAnuncios(anuncios);

        return anuncios;
    }



    /**
     * Busca todas as categorias de anúncio.
     *
     * @return
     */
    @Override
    public List<CategoriaAnuncio> findAllCategorias(){
        return categoriaRepository.findAllCategorias();
    }

    /**
     * Busca os anúncios que contenham o substring.
     *
     * @param textoBusca
     * @return
     */
    @Override
    public List<Anuncio> findAllAnunciosPublicados(String textoBusca) {
        List<Anuncio> anuncios = anuncioRepository.findAllAnunciosPublicados(textoBusca);

        loadAnuncios(anuncios);

        return anuncios;
    }

    /**
     * Retorna todos os anúncios publicados por uma lista de categorias.
     *
     * @param categoria
     * @return
     */
    @Override
    public List<Anuncio> findAllAnunciosPublicadosCategorias(List<CategoriaAnuncio> categoria) {
        List<Anuncio> anuncios = anuncioRepository.findAllAnunciosPublicadosCategoria(categoria);

        loadAnuncios(anuncios);

        return anuncios;
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

    @Override
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
            anuncio.setBem(anuncio.getBem() != null ? bemRepository.findBemById(anuncio.getBem().getId()) : null);
            anuncio.setUsuario(anuncio.getUsuario() != null ? usuarioRepository.findUsuarioById(anuncio.getUsuario().getId()) : null);
            anuncio.setStatusAnuncio(anuncio.getStatusAnuncio() != null ? statusAnuncioRepository.findStatusAnuncioById(anuncio.getStatusAnuncio().getIdentificador()) : null);
            anuncio.setCategoria(anuncio.getCategoria() != null ? categoriaRepository.findCategoriaById(anuncio.getCategoria().getIdentificador()) : null);
            anuncio.setUnidade(anuncio.getUnidade() != null ? unidadeRepository.findUnidadeById(anuncio.getUnidade().getId()) : null);
            anuncio.setInteresses(interesseRepository.findInteressesByIdAnuncio(anuncio.getId()));
            anuncio.setHistoricos(historicoAnuncioRepository.findAllHistoricosByAnuncioId(anuncio.getId()));
            anuncio.setEtiquetas(etiquetaRepository.findAllEtiquetasByAnuncioId(anuncio.getId()));
            anuncio.setFotos(fotoRepository.findAllFotosByAnuncioId(anuncio.getId()));
        }

    }

}
