package br.ufrn.reuse.facade;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;
import br.ufrn.reuse.dominio.anuncio.Etiqueta;
import br.ufrn.reuse.dominio.comum.Usuario;

/**
 * Created by Daniel on 11/8/2017.
 */

interface AnuncioFacade {

    /**
     *
     * Cadastra um anúncio
     *
     * @param anuncio
     * @return
     */
    Anuncio cadastrar(Anuncio anuncio);

    /**
     *
     * @param usuario
     * @return
     */
    List<Anuncio> findAllAnuncios(Usuario usuario);

    /**
     *
     * @param idAnuncio
     * @return
     */
    Anuncio findAnuncioById(Long idAnuncio);

    /**
     * Retorna todos os anúncios publicados
     *
     * @return
     */
    List<Anuncio> findAllAnunciosPublicados();

    List<Anuncio> findAllAnuncios(CategoriaAnuncio categoria, String denominacaoBem, Integer numeroTombamento, List<Etiqueta> etiquetas);

    /**
     * Busca todas as categorias de anúncio.
     *
     * @return
     */
    List<CategoriaAnuncio> findAllCategorias();

    /**
     * Busca os anúncios que contenham o substring.
     *
     * @param textoBusca
     * @return
     */
    List<Anuncio> findAllAnunciosPublicados(String textoBusca);

    /**
     * Retorna todos os anúncios publicados por uma lista de categorias.
     *
     * @param categoria
     * @return
     */
    List<Anuncio> findAllAnunciosPublicadosCategorias(List<CategoriaAnuncio> categoria);

    /**
     *
     * @return
     */
    List<Etiqueta> findAllEtiquetas();
}
