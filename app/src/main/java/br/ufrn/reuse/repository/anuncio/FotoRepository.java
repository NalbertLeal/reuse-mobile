package br.ufrn.reuse.repository.anuncio;

import android.content.Context;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Foto;

/**
 * Created by Daniel on 10/27/2017.
 */

public class FotoRepository {
    private final Context context;

    public FotoRepository(Context context) {
        this.context = context;
    }

    public List<Foto> findAllFotosByAnuncioId(Long id) {
        return null;
    }
}
