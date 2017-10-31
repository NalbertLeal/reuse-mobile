package br.ufrn.reuse.facade;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;
import br.ufrn.reuse.dominio.anuncio.Etiqueta;
import br.ufrn.reuse.dominio.anuncio.Interesse;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.remote.AnuncioRemoteService;
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
 * Implementação da fachada da aplicação.
 *
 * @author Nalbert
 * @author Daniel
 */
public class ReuseFacadeImpl implements ReuseFacade {

    /**
     * Dependência do módulo de anúncios.
     */
    private AnuncioFacade anuncioFacade;

    /**
     * Dependência do módulo de interesses.
     */
    private InteresseFacade interesseFacade;

    /**
     * Busca todos os anúncios publicados.
     *
     * @return todos os anúncios publicados
     */
    @Override
    public List<Anuncio> findAllAnunciosPublicados() {
        //List<Anuncio> anuncios = anuncioFacade.findAllAnunciosPublicados();




        return new AnuncioRemoteService().findAll(null);
    }

    /**
     * Busca todos os anúncios do usuário.
     *
     * @param usuario o usuário
     * @return os anúncios do usuário
     */
    @Override
    public List<Anuncio> findAllAnuncios(Usuario usuario) {
        return anuncioFacade.findAllAnuncios(usuario);
    }

    /**
     *
     * Busca todos os interesses do usuário
     *
     * @param usuario O usuário logado no sistema.
     * @return <code>List</code> contendo os interesses do usuário.
     */
    @Override
    public List<Interesse> findAllInteresse(Usuario usuario) {
        return interesseFacade.findAllInteresses(usuario);
    }

    /**
     *  Demonstra interesse em um anúncio
     *
     * @param usuario Usuário do interesado
     * @param anuncio anúncio que o usuário está interessado
     * @return interesse concretizado
     */
    @Override
    public Interesse demonstraInteresse(Usuario usuario, Anuncio anuncio){
        return interesseFacade.demonstrarInteresse(usuario, anuncio);
    }

    /**
     * Remove o interesse em um anúncio.
     *
     * @param interesse usuário
     *
     */
    @Override
    public void removerInteresse(Interesse interesse){
        interesseFacade.removerInteresse(interesse);
    }

    @Override
    public List<Anuncio> findAllAnuncios(CategoriaAnuncio categoria, String denominacaoBem, Integer numeroTombamento, List<Etiqueta> etiquetas){
        return anuncioFacade.findAllAnuncios(categoria,denominacaoBem,numeroTombamento,etiquetas);
    }

}
