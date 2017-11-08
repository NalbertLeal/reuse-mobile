package br.ufrn.reuse.remote.anuncio;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    static List<String> urlFotosMock = Arrays.asList("http://www.pokerproductos.com/WebRoot/StoreES/Shops/61976209/4D3F/07EA/8A46/F9B0/3645/C0A8/29BB/BFC4/Mesa_de_poker_redonda_CAIMAN_OCIO_negra_c.jpg", "https://images.etna.com.br/produtos/95/373995/373995_ampliada.jpg","https://i0.wp.com/ricardohage.com.br/wp-content/uploads/2017/04/computadores_0006_desktop.jpg?resize=800%2C445","https://http2.mlstatic.com/D_Q_NP_984415-MLB25225395850_122016-Q.jpg");
    private static List<Anuncio> anuncios;

    public AnuncioRemoteService(){
        this.anuncios = new ArrayList<>();
    }


    public List<Anuncio> findAll(Usuario usuario) {


        List<Anuncio> anuncios = new ArrayList<>();

        for(int i = 0; i < 30; i++ ){
            Anuncio anuncio = createAnuncio(i);

            anuncios.add(anuncio);

            Random r= new Random();
            int randomNumber = (r.nextInt() % urlFotosMock.size());
            if(randomNumber < 0) {
                randomNumber = randomNumber * -1;
            }
            String urlFotoCapa = urlFotosMock.get(randomNumber);

            anuncio.setUrlFotoCapa(urlFotoCapa);
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

    public List<Anuncio> findAllAnunciosPublicados(String textoBusca) {

        List<Anuncio> anuncios = new ArrayList<>();

        for (String nome: Arrays.asList("Cadeira Roxa", "Cadeira azul", "Cadeira Vermelha","Notebook Azul", "Notebook Novo", "Notebook Amarelo")) {
            if(nome.contains(textoBusca)) {
                Anuncio anuncio = createAnuncio(1);
                anuncio.getBem().setDenominacao(nome);

                anuncios.add(anuncio);
            }
        }

        return anuncios;
    }


    @NonNull
    private Anuncio createAnuncio(long i) {
        Anuncio anuncio = new Anuncio();

        anuncio.setId(i);
        anuncio.setTextoPublicacao("Cadeira DXRacer muito massa. Nunca foi usada. Assento regulável! Gira! Mas possui defeito.");

        Bem bem = new Bem();
        bem.setId(i);
        bem.setNumTombamento(2012121211);
        if(i%2==1)
            bem.setDenominacao("Cadeira nova, muito boa.");
        else
            bem.setDenominacao("Cadeira velha, muito ruim.");

        anuncio.setBem(bem);
        return anuncio;
    }

}