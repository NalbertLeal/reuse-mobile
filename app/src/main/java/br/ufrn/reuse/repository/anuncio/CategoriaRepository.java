package br.ufrn.reuse.repository.anuncio;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;
import br.ufrn.reuse.dominio.patrimonio.Bem;
import br.ufrn.reuse.remote.anuncio.CategoriaRemoteService;
import br.ufrn.reuse.repository.anuncio.local.CategoriaLocalRepositor;
import br.ufrn.reuse.repository.patrimonio.local.BemLocalRepository;
import br.ufrn.reuse.utils.SincronizacaoUtils;

/**
 * Created by Daniel on 10/27/2017.
 */
public class CategoriaRepository {

    private final Context context;
    private CategoriaRemoteService categoriaRemoteService;
    private CategoriaLocalRepositor categoriaLocalRepository;

    public CategoriaRepository(Context context) {
        this.context = context;
        this.categoriaRemoteService = new CategoriaRemoteService(context);
        this.categoriaLocalRepository = new CategoriaLocalRepositor(context);
    }

    public CategoriaAnuncio findCategoriaById(String identificador) {
        return categoriaRemoteService.findCategoriaById(identificador);
    }

    @NonNull
    public List<CategoriaAnuncio> findAllCategorias() {
        //return this.categoriaLocalRepository.findAllCategorias();
        return categoriaRemoteService.findAllCategorias();
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
