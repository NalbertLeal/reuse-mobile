package br.ufrn.reuse.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.logging.Level;

import br.ufrn.reuse.R;
import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.facade.ReuseFacadeImpl;

public class AnuncioViewActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncio_view);

        reuseFacade = new ReuseFacadeImpl(this);

        Long idAnuncio = getIntent().getLongExtra("idAnuncio", 0);
        //Long idAnuncio2 = getIntent().getLongExtra("id", 0);
        //logger.log(Level.SEVERE, ">>> idAnuncio: "+idAnuncio+" >>>>idView: "+idAnuncio2);

        Anuncio anuncio = reuseFacade.findAnunciobyId(idAnuncio);
        if(anuncio!=null){
            TextView text1 = (TextView)findViewById(R.id.anuncio_descricao);
            text1.setText(anuncio.getBem().getDenominacao());

            TextView text2 = (TextView)findViewById(R.id.anuncio_publicacao);
            text2.setText(anuncio.getTextoPublicacao());
        }
    }
}
