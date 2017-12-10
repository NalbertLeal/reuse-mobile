package br.ufrn.reuse.repository.comum;

import android.content.Context;

import br.ufrn.reuse.dominio.comum.Unidade;
import br.ufrn.reuse.remote.RemoteServiceConfig;
import br.ufrn.reuse.remote.comum.UnidadeRemoteService;

/**
 * Created by Daniel on 10/27/2017.
 */

public class UnidadeRepository {
    private final Context context;
    private final UnidadeRemoteService remoteService;

    public UnidadeRepository(Context context) {
        this.context = context;
        this.remoteService = RemoteServiceConfig.getAPISinfoServiceFactory().createUnidadeRemoteService(context);
    }

    public Unidade findUnidadeById(Long unidade) {
        return remoteService.findUnidadeById(unidade);
    }
}
