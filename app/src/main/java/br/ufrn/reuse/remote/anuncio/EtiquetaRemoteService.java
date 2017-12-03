package br.ufrn.reuse.remote.anuncio;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import br.ufrn.reuse.dominio.anuncio.Etiqueta;

/**
 * Created by Daniel on 11/5/2017.
 */

public class EtiquetaRemoteService {

    private final List<Etiqueta> etiquetas;

    private final Context context;

    public EtiquetaRemoteService(Context context) {
        this.context = context;

        this.etiquetas = Arrays.asList(new Etiqueta(1L,"Nunca Usado"),new Etiqueta(2L,"Possui defeito"),new Etiqueta(3L,"Funcional"));
    }

    public List<Etiqueta> findAllEtiquetas() {
        return new CopyOnWriteArrayList<>(this.etiquetas);
    }

    public List<Etiqueta> findAllEtiquetasByAnuncioId(Long id) {
        return findAllEtiquetas();
    }
}
