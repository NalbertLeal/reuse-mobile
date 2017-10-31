package br.ufrn.reuse.remote;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;
import br.ufrn.reuse.dominio.anuncio.Etiqueta;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.dominio.patrimonio.Bem;

/**
 * Implementação do acesso ao serviço remoto
 *
 * @author Daniel
 * @author Nalbert
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
            bem.setNumTombamento(2012121211);
            bem.setDenominacao("Cadeira nova, muito boa.");

            anuncio.setBem(bem);

            anuncios.add(anuncio);
        }

        return anuncios;
    }

    public Anuncio findById(Long idAnuncio) {
        return null;
    }

    public Anuncio cadatrar(Anuncio anuncio) {
        return null;
    }

    public List<Anuncio> findAllAnunciosPublicados() {
        return null;
    }

    public List<Anuncio> findAllAnuncios(CategoriaAnuncio categoria, String denominacaoBem, Integer numeroTombamento, List<Etiqueta> etiquetas) {
        return null;
    }
}
