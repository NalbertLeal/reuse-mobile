package br.ufrn.reuse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.reuse.activity.AbstractActivity;
import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;
import br.ufrn.reuse.dominio.comum.Unidade;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.facade.ReuseFacade;

public class Cadastro extends AbstractActivity {

    private ReuseFacade reuseFacade;

    private Anuncio anuncio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }




    private void iniciarComponentes() {

        List<CategoriaAnuncio> categoriaAnuncios = reuseFacade.findAllCategorias();

        Spinner spinnerCategoria = (Spinner) findViewById(R.id.spinner2);
        spinnerCategoria.setAdapter(new ArrayAdapter<CategoriaAnuncio>(this,R.layout.support_simple_spinner_dropdown_item, categoriaAnuncios));
    }


    private CategoriaAnuncio getCategoriaSelecionada() {
        Spinner spinnerCategoria = (Spinner) findViewById(R.id.spinner2);
        return (CategoriaAnuncio) spinnerCategoria.getSelectedItem();
    }



    public void cadastrar(View view){
        // Isso não funcionaaa
        anuncio.setUnidade(getUnidade());
        anuncio.setUsuario(getUsuario());
        anuncio.setCategoria(getCategoriaSelecionada());

        //TEM QUE RECUPERAR ESSAS INFORMAÇÕES DA VIEW
        anuncio.setEtiquetas(new ArrayList<>());
        anuncio.setQuantidadeDiasAtivo(15);
        anuncio.setTextoPublicacao(" ");


        //TODO: lançar os erros para a tela

    }

    private Usuario getUsuario() {
        return new Usuario();
    }

    public Unidade getUnidade() {
        return new Unidade();
    }

}

