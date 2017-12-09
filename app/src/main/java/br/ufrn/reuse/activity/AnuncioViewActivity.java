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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Anuncios");

        reuseFacade = new ReuseFacadeImpl(this);

        Long idAnuncio = getIntent().getLongExtra("idAnuncio", 0);
        Anuncio anuncio = reuseFacade.findAnunciobyId(idAnuncio);
        if(anuncio!=null){
            TextView text1 = (TextView)findViewById(R.id.view_descricao);
            text1.setText(anuncio.getBem().getDenominacao());

            Button butInteresse = (Button)findViewById(R.id.demonstrar_interesse);
            butInteresse.setOnClickListener((view) -> {
                butInteresse.setText("Interessado!");
                //Color.parseColor("#6AB344")
                butInteresse.setBackgroundColor(Color.GREEN);
            });

            String etiquetas = ".";
            if(anuncio.getEtiquetas()!=null) {
                for (Etiqueta etiqueta : anuncio.getEtiquetas()) {
                    etiquetas = etiquetas + ". " + etiqueta.getNome();
                }
            }
            TextView text2 = (TextView)findViewById(R.id.view_etiqueta);
            text2.setText(etiquetas);

            TextView text3 = (TextView)findViewById(R.id.view_tombamento);
            text3.setText("Tombamento nº: " + anuncio.getBem().getNumTombamento());

            TextView text4 = (TextView)findViewById(R.id.view_publicacao);
            text4.setText("Publicação: " + anuncio.getTextoPublicacao());

            TextView text5 = (TextView)findViewById(R.id.view_ofertante);
            text5.setText(anuncio.getUsuario() != null ? anuncio.getUsuario().getPessoa().getNome() : "Desconhecido");
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
