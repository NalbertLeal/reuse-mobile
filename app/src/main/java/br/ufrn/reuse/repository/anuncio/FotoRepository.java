package br.ufrn.reuse.repository.anuncio;

import android.content.Context;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Foto;
import br.ufrn.reuse.remote.anuncio.FotoRemoteService;

/**
 * Created by Daniel on 10/27/2017.
 */

public class FotoRepository {
    private final Context context;
    private final FotoRemoteService remoteService;

    public FotoRepository(Context context) {
        this.context = context;
        this.remoteService = new FotoRemoteService(context);
    }

    public List<Foto> findAllFotosByAnuncioId(Long idAnuncio) {
        return remoteService.findAllFotosByAnuncioId(idAnuncio);
    }
}
