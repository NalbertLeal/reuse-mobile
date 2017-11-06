package br.ufrn.reuse.repository.anuncio;

import android.content.Context;

import br.ufrn.reuse.dominio.anuncio.StatusAnuncio;
import br.ufrn.reuse.remote.anuncio.StatusAnuncioRemoteService;

/**
 * Created by Daniel on 10/27/2017.
 */
public class StatusAnuncioRepository {
    private final Context context;
    private StatusAnuncioRemoteService remoteService;

    public StatusAnuncioRepository(Context context) {
        this.context = context;
        this.remoteService = new StatusAnuncioRemoteService(context);
    }

    public StatusAnuncio findStatusAnuncioById(String identificador) {
        return remoteService.findStatusAnuncioById(identificador);
    }
}
