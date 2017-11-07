package br.ufrn.reuse.remote.anuncio;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;
import br.ufrn.reuse.dominio.anuncio.Etiqueta;
import br.ufrn.reuse.dominio.anuncio.StatusAnuncio;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.dominio.patrimonio.Bem;

/**
 * Implementação do acesso ao serviço remoto
 *
 * @author Daniel
 * @author Nalbert
 */
public class AnuncioRemoteService {

    private static List<Anuncio> anuncios;

    public AnuncioRemoteService(){
        this.anuncios = new ArrayList<>();
    }


    public List<Anuncio> findAll(Usuario usuario) {

        List<Anuncio> anuncios = new ArrayList<>();

        for(int i = 0; i < 30; i++ ){
            Anuncio anuncio = createAnuncio(i);

            anuncios.add(anuncio);
        }

        return anuncios;
    }

    public Anuncio findById(Long idAnuncio) {
        return createAnuncio(idAnuncio.intValue());
    }

    public Anuncio cadastrar(Anuncio anuncio) {
        return createAnuncio(1);
    }

    public List<Anuncio> findAllAnunciosPublicados() {
        return null;
    }

    public List<Anuncio> findAllAnuncios(CategoriaAnuncio categoria, String denominacaoBem, Integer numeroTombamento, List<Etiqueta> etiquetas) {
        return null;
    }

    @NonNull
    private Anuncio createAnuncio(int i) {
        Anuncio anuncio = new Anuncio();

        anuncio.setId((long) i);
        anuncio.setTextoPublicacao("Cadeira DXRacer muito massa. Nunca foi usada. Assento regulável! Gira! Mas possui defeito.");

        Bem bem = new Bem();
        bem.setId((long) i);
        bem.setNumTombamento(2012121211);
        if(i%2==1)
            bem.setDenominacao("Cadeira nova, muito boa.");
        else
            bem.setDenominacao("Cadeira velha, muito ruim.");

        anuncio.setBem(bem);
        return anuncio;
    }

}
