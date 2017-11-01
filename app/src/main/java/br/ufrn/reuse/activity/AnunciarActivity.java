package br.ufrn.reuse.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.reuse.R;
import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;
import br.ufrn.reuse.dominio.comum.Unidade;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.dominio.patrimonio.Bem;
import br.ufrn.reuse.facade.ReuseFacade;
import br.ufrn.reuse.facade.ReuseFacadeImpl;

public class AnunciarActivity extends AbstractActivity {

    private ReuseFacade reuseFacade;

    private Anuncio anuncio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anunciar);

        reuseFacade = new ReuseFacadeImpl(this);
        anuncio = new Anuncio();

        iniciarComponentes();

    }

    private void iniciarComponentes() {
        Button buttonSelecionarBem = (Button) findViewById(R.id.btn_buscar_bem);
        buttonSelecionarBem.setOnClickListener((view) -> selecionarBem());

        Button buttonCadastrar = (Button) findViewById(R.id.btn_cadastrar);
        buttonCadastrar.setOnClickListener((view) -> cadastrar());

        List<CategoriaAnuncio> categoriaAnuncios = reuseFacade.findAllCategorias();

        Spinner spinnerCategoria = (Spinner) findViewById(R.id.spinner_categoria);
        spinnerCategoria.setAdapter(new ArrayAdapter<CategoriaAnuncio>(this,R.layout.support_simple_spinner_dropdown_item, categoriaAnuncios));
    }

    private void selecionarBem() {
        EditText editText = (EditText) findViewById(R.id.edt_tombamento);

        int tombamento = 0;

        try{
            tombamento = Integer.parseInt(editText.getText().toString());
        }catch (NumberFormatException ex){
            // TODO: 10/31/2017 Jogar mensagem de erro caso tombamento seja inválido.
        }

        if(tombamento != 0) {

            Bem bem = reuseFacade.findBemByNumTombamento(tombamento);

            if(bem != null) {

                anuncio.setBem(bem);

                TextView textViewDenominacao = (TextView) findViewById(R.id.txt_denominacao);
                textViewDenominacao.setText(bem.getDenominacao());

                TextView textViewTombamento = (TextView) findViewById(R.id.txt_tombamento);
                textViewTombamento.setText(String.valueOf(bem.getNumTombamento()));
            }
        }
    }

    public void cadastrar(){

        anuncio.setUnidade(getUnidade());
        anuncio.setUsuario(getUsuario());
        anuncio.setCategoria(getCategoriaSelecionada());

        //TEM QUE RECUPERAR ESSAS INFORMAÇÕES DA VIEW
        anuncio.setEtiquetas(new ArrayList<>());
        anuncio.setQuantidadeDiasAtivo(15);
        anuncio.setTextoPublicacao(" ");

        List<String> erros = anuncio.validarCadastro();

        if(erros.isEmpty()){
            reuseFacade.cadastrar(anuncio);
            startActivity(new Intent(this,AnunciosActivity.class));
        }

        //TODO: lançar os erros para a tela

    }

    private CategoriaAnuncio getCategoriaSelecionada() {
        Spinner spinnerCategoria = (Spinner) findViewById(R.id.spinner_categoria);
        return (CategoriaAnuncio) spinnerCategoria.getSelectedItem();
    }

    private Usuario getUsuario() {
        return new Usuario();
    }

    public Unidade getUnidade() {
        return new Unidade();
    }
}
