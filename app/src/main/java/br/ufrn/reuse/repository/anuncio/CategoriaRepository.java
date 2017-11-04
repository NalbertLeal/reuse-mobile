package br.ufrn.reuse.repository.anuncio;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;

/**
 * Created by Daniel on 10/27/2017.
 */

public class CategoriaRepository {
    private final Context context;

    public CategoriaRepository(Context context) {
        this.context = context;
    }

    public CategoriaAnuncio findCategoriaById(String categoria) {
        return null;
    }

    @NonNull
    public List<CategoriaAnuncio> findAllCategorias() {
        List<CategoriaAnuncio> categorias = new ArrayList<>();

        categorias.add(new CategoriaAnuncio("MOBILIA", "Mobilia"));
        categorias.add(new CategoriaAnuncio("ELETRONICOS","Eletrônicos"));
        categorias.add(new CategoriaAnuncio("LABORATORIAL","Laboratorial"));
        categorias.add(new CategoriaAnuncio("OUTROS","Outros"));

        return categorias;
    }
}
