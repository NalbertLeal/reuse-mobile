package br.ufrn.reuse.repository.anuncio;

import android.content.Context;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;
import br.ufrn.reuse.dominio.anuncio.Etiqueta;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.remote.RemoteServiceConfig;
import br.ufrn.reuse.remote.anuncio.AnuncioRemoteService;
import br.ufrn.reuse.repository.anuncio.local.AnuncioLocalRepository;
import br.ufrn.reuse.utils.SincronizacaoUtils;

/**
 * Implementação do repositório de anúncios.
 *
 * @author Daniel
 */
public class AnuncioRepository {

    /**
     * Quantidade de dias que um registro poderá ser retornado sem efetuar uma consulta ao serviço remoto.
     */
    public static final int QUANTIDADE_DIAS_SINCRONIZADO_ANUNCIO = 1;

    /**
     * Dependência do serviço remoto.
      */
    private AnuncioRemoteService remoteService;

    /**
     * Dependência do repositório local.
     */
    private AnuncioLocalRepository anuncioLocalRepository;

    private final Context context;

    public AnuncioRepository(Context context) {
        this.context = context;
        this.remoteService = RemoteServiceConfig.getReuseServiceFactory().createAnuncioRemoteService(context);
        this.anuncioLocalRepository = new AnuncioLocalRepository(context);
    }

    /**
     * Retorna todos os anúncios do usuário.
     *
     * @param usuario o usuário
     * @return anúncios do usuário
     */
    public List<Anuncio> findAll(Usuario usuario) {
        return remoteService.findAll(usuario);
    }

    /**
     * Busca um anúncio pelo id
     *
     * @param idAnuncio id do anúncio
     * @return o anúncio, caso exista
     */
    public Anuncio findAnuncioById(Long idAnuncio) {

        Anuncio anuncio = anuncioLocalRepository.findById(idAnuncio);

        if(anuncio != null && !SincronizacaoUtils.isSincronizado(anuncio.getDataSincronizacao(), QUANTIDADE_DIAS_SINCRONIZADO_ANUNCIO)){
            anuncio = remoteService.findById(idAnuncio);
            anuncioLocalRepository.save(anuncio);
        }

        return anuncio;
    }

    /**
     * Efetua o cadastro de um anúncio no serviço remoto.
     *
     * @param anuncio o anúncio a ser cadastrado.
     * @return o anúncio cadastrado.
     */
    public Anuncio cadastrar(Anuncio anuncio) {
        return remoteService.cadastrar(anuncio);
    }

    /**
     * Busca todos os anúncios publicados
     *
     * @return todos os anúncios publicados
     */
    public List<Anuncio> findAllAnunciosPublicados() {
        //List<Anuncio> anuncios = new AnuncioRemoteService().findAll(null);
        return remoteService.findAllAnunciosPublicados();
    }

    /**
     * Efetua a consulta de anúncios publicados pelos filtros.
     *
     * @param categoria categoria do anúncio
     * @param denominacaoBem denominação do bem
     * @param numeroTombamento número de tombamento
     * @param etiquetas etiquetas do anúncio
     * @return Os anúncios publicados que contemplem todos os parâmetros informados.
     */
    public List<Anuncio> findAllAnuncios(CategoriaAnuncio categoria, String denominacaoBem, Integer numeroTombamento, List<Etiqueta> etiquetas) {
        return remoteService.findAllAnuncios(categoria,denominacaoBem,numeroTombamento,etiquetas);
    }

    public List<Anuncio> findAllAnunciosPublicados(String textoBusca) {

        List<Anuncio> anuncios = anuncioLocalRepository.findAllAnunciosPublicadosTexto(textoBusca);
        //Caso ao menos um esteja desincronizado, atualiza toda a listaa
        if(anuncios != null && !anuncios.isEmpty()){
            for(Anuncio an : anuncios) {
                if (!SincronizacaoUtils.isSincronizado(an.getDataSincronizacao(), QUANTIDADE_DIAS_SINCRONIZADO_ANUNCIO)){
                    anuncios = remoteService.findAllAnunciosPublicados(textoBusca);
                    saveAnuncios(anuncios);
                }
            }
        }else {
            anuncios = remoteService.findAllAnunciosPublicados(textoBusca);
            saveAnuncios(anuncios);
        }
        return anuncios;
    }

    public List<Anuncio> findAllAnunciosPublicadosCategoria(List<CategoriaAnuncio> categoria) {
        List<Anuncio> anuncios = anuncioLocalRepository.findAllAnunciosPublicadosCategoria(categoria);
        //Caso ao menos um esteja desincronizado, ou não traga resultados, atualiza toda a lista
        if(anuncios != null && !anuncios.isEmpty()){
            for(Anuncio an : anuncios) {
                if (!SincronizacaoUtils.isSincronizado(an.getDataSincronizacao(), QUANTIDADE_DIAS_SINCRONIZADO_ANUNCIO)){
                    anuncios = remoteService.findAllAnunciosCategoria(categoria);
                    saveAnuncios(anuncios);
                }
            }
        }else {
            anuncios = remoteService.findAllAnunciosCategoria(categoria);
            saveAnuncios(anuncios);
        }
        return anuncios;
    }

    private void saveAnuncio(Anuncio anuncio){
        anuncioLocalRepository.delete(anuncio);
        anuncioLocalRepository.save(anuncio);
    }

    private void saveAnuncios(List<Anuncio> anuncios){
        anuncioLocalRepository.delete(anuncios);
        anuncioLocalRepository.save(anuncios);
    }
}
