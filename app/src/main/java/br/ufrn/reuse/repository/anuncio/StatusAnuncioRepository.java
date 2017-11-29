package br.ufrn.reuse.repository.anuncio;

import android.content.Context;

import br.ufrn.reuse.dominio.anuncio.StatusAnuncio;
import br.ufrn.reuse.remote.RemoteServiceConfig;
import br.ufrn.reuse.remote.anuncio.StatusAnuncioRemoteService;

/**
 * Created by Daniel on 10/27/2017.
 */
public class StatusAnuncioRepository {
    private final Context context;
    private StatusAnuncioRemoteService remoteService;

    public StatusAnuncioRepository(Context context) {
        this.context = context;
        this.remoteService = RemoteServiceConfig.getReuseServiceFactory().createStatusAnuncioRemoteService(context);
    }

    public StatusAnuncio findStatusAnuncioById(String identificador) {
        return remoteService.findStatusAnuncioById(identificador);
    }
}
