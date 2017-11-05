package br.ufrn.reuse.remote.anuncio;

import android.content.Context;

import org.apache.commons.lang3.text.WordUtils;

import br.ufrn.reuse.dominio.anuncio.StatusAnuncio;

/**
 * Created by Daniel on 11/5/2017.
 */

public class StatusAnuncioRemoteService {
    private final Context context;

    public StatusAnuncioRemoteService(Context context) {
        this.context = context;
    }

    public StatusAnuncio findStatusAnuncioById(String identificador) {
        return new StatusAnuncio(identificador, WordUtils.capitalize(identificador.toLowerCase()));
    }
}
