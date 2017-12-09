package br.ufrn.reuse.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import android.view.View;

import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.List;


import br.ufrn.reuse.Cadastro;
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

    /**
     * Dependência da fachada da aplicação.
     */
    private ReuseFacade reuseFacade;

    /**
     * Anúncio que está sendo populado com os dados do cadastro.
     */
    private Anuncio anuncio;

    /**
     * Bem selecionado.
     */
    public Bem bem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_anunciar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Anunciar");
        reuseFacade = new ReuseFacadeImpl(this);
        anuncio = new Anuncio();

        iniciarComponentes();

    }

    /**
     * Carrega os componentes da view.
     */
    private void iniciarComponentes() {
        Button buttonSelecionarBem = (Button) findViewById(R.id.btn_buscar_bem);

        buttonSelecionarBem.setOnClickListener((view) -> selecionarBem());

        Button buttonCadastrar = (Button) findViewById(R.id.btn_avancar);
        buttonCadastrar.setOnClickListener((view) -> avancarCadastro());

        List<CategoriaAnuncio> categoriaAnuncios = reuseFacade.findAllCategorias();

        //Spinner spinnerCategoria = (Spinner) findViewById(R.id.spinner_categoria);
        //spinnerCategoria.setAdapter(new ArrayAdapter<CategoriaAnuncio>(this,R.layout.support_simple_spinner_dropdown_item, categoriaAnuncios));
    }

    /**
     * Efetua a seleção do bem com base no tombamento informado na view.
     */
    private void selecionarBem() {

        try{
            EditText editText = (EditText) findViewById(R.id.edt_tombamento);
            int tombamento = Integer.parseInt(editText.getText().toString());
            carregarBem(tombamento);
        }catch (NumberFormatException ex){
            showErrorOnToast("O codigo de Barras do tombamento é invalido",10000);
        }

    }

    /**
     * Carrega o bem de acordo com o tombamento passado.
     *
     * @param tombamento
     */
    private void carregarBem(int tombamento) {
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

    /**
     * Efetua o cadastro do anúncio.
     */
    public void cadastrar(){
        anuncio.setUnidade(getUnidade());
        anuncio.setUsuario(getUsuario());
        anuncio.setCategoria(getCategoriaSelecionada());

        //TODO: Recuperar da view
        anuncio.setEtiquetas(new ArrayList<>());
        anuncio.setQuantidadeDiasAtivo(15);
        anuncio.setTextoPublicacao(" ");

        List<String> erros = new ArrayList<>();

        //TODO: List<String> erros = anuncio.validarCadastro();

        if(erros.isEmpty()){
            reuseFacade.cadastrar(anuncio);
            startActivity(new Intent(this,MeusAnunciosActivity.class));
        }

        //TODO: lançar os erros para a tela

    }

    /**
     * Retorna a categoria selecionada na view do cadastro.
     *
     * @return
     */
    private CategoriaAnuncio getCategoriaSelecionada() {
        Spinner spinnerCategoria = (Spinner) findViewById(R.id.spinner2);
        return (CategoriaAnuncio) spinnerCategoria.getSelectedItem();
    }

    /**
     * Retorna para a vitrine
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(this, VitrineActivity.class));
            finishAffinity();
        }

        return true;
    }

    /**
     *  Inicia a activity de leitura de tombamento com scanner.
     *
     * @param view
     */
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
                    showErrorOnToast("O codigo de Barras  do tombamento é invalido",10000);
                }else{

                    try {
                        int numTombamento = Integer.parseInt(tombamento);
                        carregarBem(numTombamento);
                    }catch (NumberFormatException exception){
                        showErrorOnToast("O codigo de Barras  do tombamento é invalido",10000);
                    }

                }

            }
        }
    }

    /**
     * Avança o cadastro para a etapa da inserção dos dados do anúncio.
     */
    public void avancarCadastro() {
        Intent intent = new Intent(this, Cadastro.class);
        intent.putExtra("Bem", bem);
        this.startActivity(intent);
    }


    private Usuario getUsuario() {
        //TODO: Retornar usuário
        return new Usuario();
    }

    public Unidade getUnidade() {
        //TODO: Retornar unidade do usuário
        return new Unidade();
    }

    @Override
    public void handleResult(Result result) {}

}
