package br.ufrn.reuse.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import android.view.View;

import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.List;


import br.ufrn.reuse.Cadastro;
import br.ufrn.reuse.LerTombamento;
import br.ufrn.reuse.R;
import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;
import br.ufrn.reuse.dominio.comum.Unidade;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.dominio.patrimonio.Bem;
import br.ufrn.reuse.facade.ReuseFacade;
import br.ufrn.reuse.facade.ReuseFacadeImpl;
import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class AnunciarActivity extends AbstractActivity implements ZXingScannerView.ResultHandler{

    private ReuseFacade reuseFacade;

    private Anuncio anuncio;

    private static final int REQUISICAO_CAM = 1;
    private ZXingScannerView scannerView;

    public Bem bem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        scannerView = new ZXingScannerView(this);

        setContentView(R.layout.activity_anunciar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Anunciar");
        reuseFacade = new ReuseFacadeImpl(this);
        anuncio = new Anuncio();

        iniciarComponentes();

    }

    private void iniciarComponentes() {
        Button buttonSelecionarBem = (Button) findViewById(R.id.btn_buscar_bem);

        buttonSelecionarBem.setOnClickListener((view) -> selecionarBem());

        Button buttonCadastrar = (Button) findViewById(R.id.btn_avancar);
        buttonCadastrar.setOnClickListener((view) -> avancarCadastro());

        List<CategoriaAnuncio> categoriaAnuncios = reuseFacade.findAllCategorias();

        //Spinner spinnerCategoria = (Spinner) findViewById(R.id.spinner_categoria);
        //spinnerCategoria.setAdapter(new ArrayAdapter<CategoriaAnuncio>(this,R.layout.support_simple_spinner_dropdown_item, categoriaAnuncios));
    }

    private void selecionarBem() {


        EditText editText = (EditText) findViewById(R.id.edt_tombamento);

        int tombamento = 0;

        try{
            //editText.setHint(tombamento);
            tombamento = Integer.parseInt(editText.getText().toString());
        }catch (NumberFormatException ex){
            // TODO: 10/31/2017 Jogar mensagem de erro caso tombamento seja inválido.
        }

        selecionarBem(tombamento);
    }

    private void selecionarBem(int tombamento) {
        if(tombamento != 0) {

            bem = reuseFacade.findBemByNumTombamento(tombamento);

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

        List<String> erros = new ArrayList<>();//anuncio.validarCadastro();

        if(erros.isEmpty()){
            reuseFacade.cadastrar(anuncio);
            startActivity(new Intent(this,MeusAnunciosActivity.class));
        }

        //TODO: lançar os erros para a tela

    }

    private CategoriaAnuncio getCategoriaSelecionada() {
        Spinner spinnerCategoria = (Spinner) findViewById(R.id.spinner2);
        return (CategoriaAnuncio) spinnerCategoria.getSelectedItem();
    }

    private Usuario getUsuario() {
        return new Usuario();
    }

    public Unidade getUnidade() {
        return new Unidade();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, VitrineActivity.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }


    @Override
    public void handleResult(Result result) {

    }

    public void lerTombamento(View view){
        Intent intent = new Intent(this, LerTombamento.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                String tombamento = data.getStringExtra("resultado");
                if(tombamento.length() != 10) {
                    Log.d("Tombamento", "Errado");
                }else{

                    try {
                        int numTombamento = Integer.parseInt(tombamento);
                        selecionarBem(numTombamento);
                    }catch (NumberFormatException exception){
                        showErrorOnToast("O codigo de Barras  do tombamento invalido",10000);
                    }

                }

            }
        }
    }

    public void avancarCadastro() {
        Intent intent = new Intent(this, Cadastro.class);
        intent.putExtra("Bem", bem);
        this.startActivity(intent);
    }

}
