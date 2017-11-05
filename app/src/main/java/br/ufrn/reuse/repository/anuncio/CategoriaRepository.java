package br.ufrn.reuse.repository.anuncio;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;
import br.ufrn.reuse.remote.anuncio.CategoriaRemoteService;

/**
 * Created by Daniel on 10/27/2017.
 */
public class CategoriaRepository {

    private final Context context;
    private CategoriaRemoteService categoriaRemoteService;

    public CategoriaRepository(Context context) {
        this.context = context;
        this.categoriaRemoteService = new CategoriaRemoteService(context);
    }

    public CategoriaAnuncio findCategoriaById(String identificador) {
        return categoriaRemoteService.findCategoriaById(identificador);
    }

    @NonNull
    public List<CategoriaAnuncio> findAllCategorias() {
        return categoriaRemoteService.findAllCategorias();
    }
}
