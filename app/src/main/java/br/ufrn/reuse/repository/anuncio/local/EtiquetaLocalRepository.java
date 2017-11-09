package br.ufrn.reuse.repository.anuncio.local;

import android.content.Context;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Etiqueta;

/**
 * Created by Daniel on 10/27/2017.
 */

public class EtiquetaLocalRepository {
    private final Context context;

    public EtiquetaLocalRepository(Context context) {
        this.context = context;
    }

    public List<Etiqueta> findAllEtiquetas() {
        return null;
    }

    public List<Etiqueta> finAllEtiquetasByAnuncioId(Long id) {
        return null;
    }
}
