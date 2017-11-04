package br.ufrn.reuse.repository.anuncio;

import android.content.Context;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Etiqueta;
import br.ufrn.reuse.repository.anuncio.local.EtiquetaLocalRepository;

/**
 * Created by Daniel on 10/27/2017.
 */
public class EtiquetaRepository {
    private final Context context;

    private EtiquetaLocalRepository localRepository;

    public EtiquetaRepository(Context context) {
        this.context = context;
    }

    public List<Etiqueta> findAllEtiquetasByAnuncioId(Long id) {
        return localRepository.finAllEtiquetasByAnuncioId(id);
    }

    public List<Etiqueta> findAllEtiquetas() {
        return localRepository.findAllEtiquetas();
    }
}
