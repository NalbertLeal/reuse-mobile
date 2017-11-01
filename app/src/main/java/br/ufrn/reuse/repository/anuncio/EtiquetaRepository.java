package br.ufrn.reuse.repository.anuncio;

import android.content.Context;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Etiqueta;

/**
 * Created by Daniel on 10/27/2017.
 */
public class EtiquetaRepository {
    private final Context context;

    public EtiquetaRepository(Context context) {
        this.context = context;
    }

    public List<Etiqueta> findAllEtiquetasByAnuncioId(Long id) {
        return null;
    }
}
