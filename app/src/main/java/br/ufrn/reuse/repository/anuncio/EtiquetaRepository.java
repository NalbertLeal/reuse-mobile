package br.ufrn.reuse.repository.anuncio;

import android.content.Context;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Etiqueta;
import br.ufrn.reuse.remote.RemoteServiceConfig;
import br.ufrn.reuse.remote.anuncio.EtiquetaRemoteService;
import br.ufrn.reuse.repository.anuncio.local.EtiquetaLocalRepository;

/**
 * Created by Daniel on 10/27/2017.
 */
public class EtiquetaRepository {
    private final Context context;

    private EtiquetaLocalRepository localRepository;

    private EtiquetaRemoteService remoteService;

    public EtiquetaRepository(Context context) {
        this.context = context;
        this.remoteService = RemoteServiceConfig.getReuseServiceFactory().createEtiquetaRemoteService(context);
        this.localRepository = new EtiquetaLocalRepository(context);
    }

    public List<Etiqueta> findAllEtiquetasByAnuncioId(Long id) {
        List<Etiqueta> etiquetas = localRepository.findAllEtiquetasByAnuncioId(id);
        if(etiquetas==null || etiquetas.isEmpty()){
            etiquetas = remoteService.findAllEtiquetasByAnuncioId(id);
            localRepository.saveByAnuncio(etiquetas, id);
        }
        return etiquetas;
    }

    public List<Etiqueta> findAllEtiquetas() {
        List<Etiqueta> etiquetas = localRepository.findAllEtiquetas();
        if(etiquetas==null || etiquetas.isEmpty()){
            etiquetas = remoteService.findAllEtiquetas();
            localRepository.save(etiquetas);
        }
        return etiquetas;
    }
}
