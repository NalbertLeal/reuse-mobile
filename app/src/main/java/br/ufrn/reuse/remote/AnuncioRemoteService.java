package br.ufrn.reuse.remote;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.dominio.patrimonio.Bem;

/**
 * Created by nalbertg on 26/10/17.
 */
public class AnuncioRemoteService {

    public List<Anuncio> findAll(Usuario usuario) {

        List<Anuncio> anuncios = new ArrayList<>();

        for(int i = 0; i < 30; i++ ){
            Anuncio anuncio = new Anuncio();

            anuncio.setId(Long.valueOf(i));
            anuncio.setTextoPublicacao("Cadeira DXRacer muito massa. Nunca foi usada. Assento regulável! Gira! Mas possui defeito.");

            Bem bem = new Bem();
            bem.setId(Long.valueOf(i));

            anuncios.add(anuncio);
        }

        return anuncios;
    }
}
