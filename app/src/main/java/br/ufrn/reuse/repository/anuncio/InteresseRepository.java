package br.ufrn.reuse.repository.anuncio;

import android.content.Context;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.Interesse;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.remote.RemoteServiceConfig;
import br.ufrn.reuse.remote.anuncio.InteresseRemoteService;
import br.ufrn.reuse.repository.anuncio.local.InteresseLocalRepository;
import br.ufrn.reuse.utils.SincronizacaoUtils;

/**
 * Created by Daniel on 10/27/2017.
 */
public class InteresseRepository {

    private final Context context;
    private final InteresseRemoteService remoteService;
    private final InteresseLocalRepository interesseLocalRepository;

    public static final int QUANTIDADE_DIAS_SINCRONIZADO_ANUNCIO = 1;

    public InteresseRepository(Context context) {
        this.context = context;
        this.remoteService = RemoteServiceConfig.getReuseServiceFactory().createInteresseAnuncioRemoteService(context);
        this.interesseLocalRepository = new InteresseLocalRepository(context);
    }

    public List<Interesse> findInteressesByIdAnuncio(Long id) {
        List<Interesse> interesses = interesseLocalRepository.findAllInteressesByAnuncioId(id);
        if(interesses==null || interesses.isEmpty()){
            interesses = remoteService.findInteressesByIdAnuncio(id);
            interesseLocalRepository.save(interesses);
        }
        return interesses;
    }

    public List<Interesse> findAllInteresses(Usuario usuario) {
        List<Interesse> interesses = interesseLocalRepository.getAllInteresses();
        if(interesses==null || interesses.isEmpty()){
            interesses = remoteService.findAllInteresses(usuario);
            interesseLocalRepository.save(interesses);
        }
        return interesses;
    }

    public Interesse demonstrarInteresse(Usuario usuario, Anuncio anuncio) {
        Interesse inter = remoteService.demonstrarInteresse(usuario,anuncio);
        interesseLocalRepository.save(inter);
        return inter;
    }

    public void removerInteresse(Interesse interesse) {
        remoteService.removerInteresse(interesse);
        interesseLocalRepository.delete(interesse);
    }
}
