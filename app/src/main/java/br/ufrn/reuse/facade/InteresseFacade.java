package br.ufrn.reuse.facade;

import android.content.Context;

import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.Interesse;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.repository.anuncio.InteresseRepository;

/**
 * Created by Daniel on 10/27/2017.
 */
public class InteresseFacade {
    private InteresseRepository interesseRepository;

    public InteresseFacade(Context context) {
        this.interesseRepository = new InteresseRepository(context);
    }

    public List<Interesse> findAllInteresses(Usuario usuario) {
        return interesseRepository.findAllInteresses(usuario);
    }

    public Interesse demonstrarInteresse(Usuario usuario, Anuncio anuncio) {
        return interesseRepository.demonstrarInteresse(usuario,anuncio);
    }

    public void removerInteresse(Interesse interesse) {
        interesseRepository.removerInteresse(interesse);
    }
}
