package br.ufrn.reuse.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.logging.Level;

import br.ufrn.reuse.R;
import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.Etiqueta;
import br.ufrn.reuse.facade.ReuseFacadeImpl;

public class AnuncioViewActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncio_view);

        reuseFacade = new ReuseFacadeImpl(this);

        Long idAnuncio = getIntent().getLongExtra("idAnuncio", 0);
        Anuncio anuncio = reuseFacade.findAnunciobyId(idAnuncio);
        if(anuncio!=null){
            TextView text1 = (TextView)findViewById(R.id.view_descricao);
            text1.setText(anuncio.getBem().getDenominacao());

            TextView text2 = (TextView)findViewById(R.id.view_etiqueta);
            if(anuncio.getEtiquetas()!=null) {
                for (Etiqueta etiqueta : anuncio.getEtiquetas()) {
                    text2.setText(etiqueta.getNome());
                }
            }

            TextView text3 = (TextView)findViewById(R.id.view_tombamento);
            text3.setText("Tombamento nº: " + anuncio.getBem().getNumTombamento());

            TextView text4 = (TextView)findViewById(R.id.view_publicacao);
            text2.setText(anuncio.getTextoPublicacao());

            TextView text5 = (TextView)findViewById(R.id.view_ofertante);
            text2.setText(anuncio.getTextoPublicacao());
        }
    }
}
