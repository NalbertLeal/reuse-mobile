package br.ufrn.reuse.repository.anuncio;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;
import br.ufrn.reuse.remote.RemoteServiceConfig;
import br.ufrn.reuse.remote.anuncio.CategoriaRemoteService;
import br.ufrn.reuse.repository.anuncio.local.CategoriaLocalRepository;

/**
 * Created by Daniel on 10/27/2017.
 */
public class CategoriaRepository {

    private final Context context;
    private CategoriaRemoteService categoriaRemoteService;
    private CategoriaLocalRepository categoriaLocalRepository;

    public CategoriaRepository(Context context) {
        this.context = context;
        this.categoriaRemoteService = RemoteServiceConfig.getReuseServiceFactory().createCategoriaRemoteService(context);
        this.categoriaLocalRepository = new CategoriaLocalRepository(context);
    }

    public CategoriaAnuncio findCategoriaById(String identificador) {
        CategoriaAnuncio cat = this.categoriaLocalRepository.findCategoriaById(identificador);
        if(cat==null || cat.getIdentificador().isEmpty()) {
            cat = categoriaRemoteService.findCategoriaById(identificador);
        }
        return cat;
    }

    @NonNull
    public List<CategoriaAnuncio> findAllCategorias() {
        List<CategoriaAnuncio> categorias = this.categoriaLocalRepository.findAllCategorias();

        if(categorias==null || categorias.isEmpty()) {
            categorias = categoriaRemoteService.findAllCategorias();
            categoriaLocalRepository.save(categorias);
        }

        return categorias;
    }

    public CategoriaAnuncio findBemById(String idCategoria){
        CategoriaAnuncio categoria = categoriaLocalRepository.findCategoriaById(idCategoria);

        if(categoria == null){
            categoria = categoriaRemoteService.findCategoriaById(idCategoria);
            //bemLocalRepository.save(bem);
            // TODO descomentar
        }

        return categoria;

    }
}
