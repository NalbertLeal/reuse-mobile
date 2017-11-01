package br.ufrn.reuse.repository.anuncio;

import android.content.Context;

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
}
