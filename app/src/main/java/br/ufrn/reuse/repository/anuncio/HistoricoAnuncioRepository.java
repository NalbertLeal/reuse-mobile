package br.ufrn.reuse.repository.anuncio;

import android.content.Context;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.HistoricoAnuncio;

/**
 * Created by Daniel on 10/27/2017.
 */

public class HistoricoAnuncioRepository {
    private final Context context;

    public HistoricoAnuncioRepository(Context context) {
        this.context = context;
    }

    public List<HistoricoAnuncio> findAllHistoricosByAnuncioId(Long id) {
        return null;
    }
}
