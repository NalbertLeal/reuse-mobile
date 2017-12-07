package br.ufrn.reuse.repository.anuncio;

import android.content.Context;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.HistoricoAnuncio;
import br.ufrn.reuse.remote.RemoteServiceConfig;
import br.ufrn.reuse.remote.anuncio.HistoricoAnuncioRemoteService;

/**
 * Created by Daniel on 10/27/2017.
 */

public class HistoricoAnuncioRepository {
    private final Context context;
    private final HistoricoAnuncioRemoteService remoteService;

    public HistoricoAnuncioRepository(Context context) {
        this.context = context;
        this.remoteService = RemoteServiceConfig.getReuseServiceFactory().createHistoricoAnuncioRemoteService(context);
    }

    public List<HistoricoAnuncio> findAllHistoricosByAnuncioId(Long id) {
        return remoteService.findAllHistoricosByAnuncioId(id);
    }
}
