package br.ufrn.reuse.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import br.ufrn.reuse.R;
import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.utils.PegarImagemAnuncio;

/**
 * Created by nalbertg on 07/11/2017.
 */

public class MeusAnunciosActivity extends AbstractActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_anuncios);

        ImageView fotoUsuario = (ImageView) findViewById(R.id.imageView2);

        PegarImagemAnuncio p = new PegarImagemAnuncio(fotoUsuario);
        p.execute();

        TextView nomeUsuario = (TextView) findViewById(R.id.nome_usuario);
        nomeUsuario.setText("Nabert Gabriel");

        ArrayList<Anuncio> anuncios = new ArrayList<Anuncio>();
        MeusAnunciosAdapter adapter = new MeusAnunciosAdapter(this, anuncios);

        LinearLayout linearLayoutMeusAnuncios = (LinearLayout) findViewById(R.id.linear_layout_meus_anuncios);
        for (int i = 0; i < anuncios.size(); i++) {
            linearLayoutMeusAnuncios.addView(adapter.getView(i));
        }
    }
}
