package br.ufrn.reuse.remote.factory;

import android.content.Context;

import br.ufrn.reuse.remote.anuncio.AnuncioRemoteService;
import br.ufrn.reuse.remote.anuncio.CategoriaRemoteService;
import br.ufrn.reuse.remote.anuncio.EtiquetaRemoteService;
import br.ufrn.reuse.remote.anuncio.FotoRemoteService;
import br.ufrn.reuse.remote.anuncio.HistoricoAnuncioRemoteService;
import br.ufrn.reuse.remote.anuncio.InteresseRemoteService;
import br.ufrn.reuse.remote.anuncio.StatusAnuncioRemoteService;

/**
 * Created by Daniel on 11/28/2017.
 */
public interface ReuseServiceFactory {

    AnuncioRemoteService createAnuncioRemoteService(Context context);

    CategoriaRemoteService createCategoriaRemoteService(Context context);

    EtiquetaRemoteService createEtiquetaRemoteService(Context context);

    FotoRemoteService createFotoRemoteService(Context context);

    HistoricoAnuncioRemoteService createHistoricoAnuncioRemoteService(Context context);

    InteresseRemoteService createInteresseAnuncioRemoteService(Context context);

    StatusAnuncioRemoteService createStatusAnuncioRemoteService(Context context);


}
