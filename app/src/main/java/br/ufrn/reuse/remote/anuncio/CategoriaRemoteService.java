package br.ufrn.reuse.remote.anuncio;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;

/**
 * Created by Daniel on 11/5/2017.
 */
public class CategoriaRemoteService {

    private final List<CategoriaAnuncio> categorias;
    private final Context context;

    public CategoriaRemoteService(Context context) {
        this.context = context;

        this.categorias = Arrays.asList(new CategoriaAnuncio("MOBILIA", "Mobilia"),
                new CategoriaAnuncio("ELETRONICOS", "Eletrônicos"),
                new CategoriaAnuncio("LABORATORIAL", "Laboratorial"),
                new CategoriaAnuncio("OUTROS", "Outros"));
    }

    public List<CategoriaAnuncio> findAllCategorias() {
        return new CopyOnWriteArrayList<>(categorias);
    }

    public CategoriaAnuncio findCategoriaById(String identificador) {
        return this.categorias.stream()
                .filter(categoria -> categoria.equals(identificador))
                .findFirst()
                .get();
    }

}
