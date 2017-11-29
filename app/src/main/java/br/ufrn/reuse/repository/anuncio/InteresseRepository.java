package br.ufrn.reuse.repository.anuncio;

import android.content.Context;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.Interesse;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.remote.RemoteServiceConfig;
import br.ufrn.reuse.remote.anuncio.InteresseRemoteService;

/**
 * Created by Daniel on 10/27/2017.
 */
public class InteresseRepository {

    private final Context context;
    private final InteresseRemoteService remoteService;

    public InteresseRepository(Context context) {
        this.context = context;
        this.remoteService = RemoteServiceConfig.getReuseServiceFactory().createInteresseAnuncioRemoteService(context);
    }

    public List<Interesse> findInteressesByIdAnuncio(Long id) {
        return remoteService.findInteressesByIdAnuncio(id);
    }

    public List<Interesse> findAllInteresses(Usuario usuario) {
        return remoteService.findAllInteresses(usuario);
    }

    public Interesse demonstrarInteresse(Usuario usuario, Anuncio anuncio) {
        return remoteService.demonstrarInteresse(usuario,anuncio);
    }

    public void removerInteresse(Interesse interesse) {
        remoteService.removerInteresse(interesse);
    }
}
