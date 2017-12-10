package br.ufrn.reuse.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import br.ufrn.reuse.R;
import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.Etiqueta;
import br.ufrn.reuse.facade.ReuseFacadeImpl;

public class AnuncioViewActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncio_view);
        iniciaBarraSuperior("Anuncios");

        reuseFacade = new ReuseFacadeImpl(this);

        //TODO: CHAMAR COM ASYNCTASK
        Long idAnuncio = getIntent().getLongExtra("idAnuncio", 0);
        Anuncio anuncio = reuseFacade.findAnunciobyId(idAnuncio);

        if(anuncio!=null){
            TextView textViewDescricaoBem = (TextView)findViewById(R.id.view_descricao);
            textViewDescricaoBem.setText(anuncio.getBem().getDenominacao());

            Button butInteresse = (Button)findViewById(R.id.demonstrar_interesse);
            butInteresse.setOnClickListener((view) -> {
                butInteresse.setText("Interessado!");
                butInteresse.setBackgroundColor(Color.GREEN);
            });

            String etiquetas = ".";
            if(anuncio.getEtiquetas()!= null) {
                for (Etiqueta etiqueta : anuncio.getEtiquetas()) {
                    etiquetas = etiquetas + ". " + etiqueta.getNome();
                }
            }

            TextView textViewEtiqueta = (TextView)findViewById(R.id.view_etiqueta);
            textViewEtiqueta.setText(etiquetas);

            TextView textViewNumeroTombamento = (TextView)findViewById(R.id.view_tombamento);
            textViewNumeroTombamento.setText("Tombamento nº: " + anuncio.getBem().getNumTombamento());

            TextView textViewPublicacao = (TextView)findViewById(R.id.view_publicacao);
            textViewPublicacao.setText("Publicação: " + anuncio.getTextoPublicacao());

            TextView textViewOfertante = (TextView)findViewById(R.id.view_ofertante);
            textViewOfertante.setText(anuncio.getUsuario() != null ? anuncio.getUsuario().getPessoa().getNome() : "Desconhecido");
        }

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

}
