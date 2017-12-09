package br.ufrn.reuse;

import android.os.Bundle;
import android.util.Log;
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
import br.ufrn.reuse.facade.ReuseFacadeImpl;

public class Cadastro extends AbstractActivity {

    private ReuseFacade reuseFacade;
    private Anuncio anuncio;
    List<CategoriaAnuncio> categoriaAnuncios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        reuseFacade = new ReuseFacadeImpl(this);
        anuncio = new Anuncio();

        iniciarComponentes();
    }


    private void iniciarComponentes() {
        Button cadastrar = (Button) findViewById(R.id.btn_cadastrar);
        cadastrar.setOnClickListener((view) -> cadastrar());

        categoriaAnuncios = reuseFacade.findAllCategorias();

        Spinner spinnerCategoria = (Spinner) findViewById(R.id.spinner2);
        spinnerCategoria.setAdapter(new ArrayAdapter<CategoriaAnuncio>(this,R.layout.support_simple_spinner_dropdown_item, categoriaAnuncios));
    }


    public void cadastrar(){

        Log.d("Cadastrar","...");
        anuncio.setUnidade(getUnidade());
        anuncio.setUsuario(getUsuario());
        anuncio.setCategoria(getCategoriaSelecionada());

        //TEM QUE RECUPERAR ESSAS INFORMAÇÕES DA VIEW
        anuncio.setEtiquetas(new ArrayList<>());
        anuncio.setQuantidadeDiasAtivo(15);
        anuncio.setTextoPublicacao(" ");

        List<String> erros = new ArrayList<>();//anuncio.validarCadastro();

        if(erros.isEmpty()){
            Log.d("Error","...");
            reuseFacade.cadastrar(anuncio);
            //startActivity(new Intent(this,MeusAnunciosActivity.class));
        }

        //TODO: lançar os erros para a tela

    }

    private Usuario getUsuario() {
        return new Usuario();
    }

    public Unidade getUnidade() {
        return new Unidade();
    }

    private CategoriaAnuncio getCategoriaSelecionada() {
        Spinner spinnerCategoria = (Spinner) findViewById(R.id.spinner2);
        return (CategoriaAnuncio) spinnerCategoria.getSelectedItem();
    }


}

