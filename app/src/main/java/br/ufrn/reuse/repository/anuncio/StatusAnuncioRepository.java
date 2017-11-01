package br.ufrn.reuse.repository.anuncio;

import android.content.Context;

import br.ufrn.reuse.dominio.anuncio.StatusAnuncio;

/**
 * Created by Daniel on 10/27/2017.
 */

public class StatusAnuncioRepository {
    private final Context context;

    public StatusAnuncioRepository(Context context) {
        this.context = context;
    }

    public StatusAnuncio findStatusAnuncioById(String identificador) {
        return null;
    }
}
