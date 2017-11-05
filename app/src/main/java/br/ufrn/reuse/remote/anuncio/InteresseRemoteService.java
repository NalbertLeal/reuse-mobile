package br.ufrn.reuse.remote.anuncio;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.Interesse;
import br.ufrn.reuse.dominio.anuncio.StatusInteresse;
import br.ufrn.reuse.dominio.comum.Usuario;

/**
 * Created by Daniel on 11/5/2017.
 */

public class InteresseRemoteService {

    private static Long interesseSeq = 0L;
    private final List<Interesse> interesses;
    private final Context context;

    public InteresseRemoteService(Context context) {
        this.context = context;

        this.interesses = new ArrayList<>();
    }

    public List<Interesse> findInteressesByIdAnuncio(Long id) {

        List<Interesse> interessesAnuncio = new ArrayList<>();

        for (Interesse interesse : interesses) {
            if(interesse.getAnuncio() != null && interesse.getAnuncio().getId().equals(id)) {
                interessesAnuncio.add(interesse);
            }
        }

        return interessesAnuncio;
    }

    public List<Interesse> findAllInteresses(Usuario usuario) {
        List<Interesse> interessesAnuncio = new ArrayList<>();

        for (Interesse interesse : interesses) {
            if(interesse.getInteressado() != null && interesse.getInteressado().equals(usuario)) {
                interessesAnuncio.add(interesse);
            }
        }

        return interessesAnuncio;

    }

    public Interesse demonstrarInteresse(Usuario usuario, Anuncio anuncio) {

        Interesse interesse = null;

        Optional<Interesse> optInteresse = interesses.stream()
                .filter(interesseAnuncio -> interesseAnuncio.getAnuncio().equals(anuncio)
                        && interesseAnuncio.getInteressado().equals(usuario)).findFirst();

        if(!optInteresse.isPresent()){
            interesse = new Interesse();

            interesse.setId(++interesseSeq);
            interesse.setAnuncio(anuncio);
            interesse.setStatus(new StatusInteresse("REGISTRADO_INTERESSE","Registrado interesse"));
            interesse.setDataInteresse(new Date());
            interesse.setInteressado(usuario);

        }else{
            interesse = optInteresse.get();
        }

        return interesse;
    }

    public void removerInteresse(Interesse interesse) {
        Optional<Interesse> optInteresse = interesses.stream()
                .filter(interesseAnuncio -> interesseAnuncio.equals(interesse))
                .findFirst();

        if(optInteresse.isPresent()){
            interesses.remove(interesse);
        }

    }
}
