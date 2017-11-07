package br.ufrn.reuse.remote.anuncio;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
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

    public List<Anuncio> findAllAnunciosCategoria(List<CategoriaAnuncio> categorias) {
        List<Anuncio> anuncios = new ArrayList<Anuncio>();

        if(categorias != null && categorias.size() > 0) {
            for (Anuncio anuncio : findAll(null)) {
                for (CategoriaAnuncio cat : categorias) {
                    if (anuncio.getCategoria().getDescricao() == cat.getDescricao()) {
                        anuncios.add(anuncio);
                        break;
                    }
                }
            }
        }else{
            return findAll(null);
        }
        return anuncios;
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
        if(i%2==1) {
            bem.setDenominacao("Cadeira nova, muito boa.");
            anuncio.setCategoria(new CategoriaAnuncio("ELETRONICOS", "Eletrônicos"));
        }else {
            bem.setDenominacao("Cadeira velha, muito ruim.");
            anuncio.setCategoria(new CategoriaAnuncio("OUTROS", "Outros"));
        }
        anuncio.setBem(bem);
        return anuncio;
    }


}