package br.ufrn.reuse.repository.anuncio.local;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.patrimonio.Bem;

/**
 * Created by nalbertg on 26/10/17.
 */
public class AnuncioLocalRepository {

    public Anuncio findById(Long idAnuncio) {
        Anuncio anuncio = new Anuncio();

        anuncio.setId(idAnuncio);
        anuncio.setTextoPublicacao("Cadeira DXRacer muito massa. Nunca foi usada. Assento regulável! Gira! Mas possui defeito.");

        Bem bem = new Bem();
        bem.setId(idAnuncio);

        return anuncio;
    }

    public void save(Anuncio anuncio) {

    }
}
