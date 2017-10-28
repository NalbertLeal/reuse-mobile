package br.ufrn.reuse.facade;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;
import br.ufrn.reuse.dominio.anuncio.Etiqueta;
import br.ufrn.reuse.dominio.anuncio.Interesse;
import br.ufrn.reuse.dominio.comum.Usuario;

/**
 * Fachada da aplicação.
 *
 * @author Daniel
 * @author Nalbert
 */
public interface ReuseFacade {
    //TODO: PAGINAÇÃO
    List<Anuncio> findAllAnunciosPublicados();
    List<Anuncio> findAllAnuncios(Usuario usuario);
    List<Interesse> findAllInteresse(Usuario usuario);
    Interesse demonstraInteresse(Usuario usuario, Anuncio anuncio);
    void removerInteresse(Interesse interesse);
    List<Anuncio> findAllAnuncios(CategoriaAnuncio categoria, String denominacaoBem, Integer numeroTombamento, List<Etiqueta> etiquetas);
}
