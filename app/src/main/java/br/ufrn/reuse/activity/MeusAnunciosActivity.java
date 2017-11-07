package br.ufrn.reuse.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

import br.ufrn.reuse.R;
import br.ufrn.reuse.dominio.anuncio.Anuncio;

public class MeusAnunciosActivity extends AppCompatActivity {

    private ArrayList<Anuncio> anuncios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_anuncios);
        // pegar os auncios desse usuario do repositorio remoto
        // colocar esses anuncios dentro do ArrayList this.anuncios

        for(int i = 0; i < this.anuncios.size(); i++) {
            /*
                enquanto tiver anuncio dentro do ArrayList ele instância na view
                um "LinearLayout" que possui os dados do anuncio: foto, situação,
                numero de interessese e o atual responsavel pelo objeto do anuncio
            */
            ScrollView anunciosSV = (ScrollView) findViewById(R.id.anunciosScroll);

            LinearLayout anuncioLL = new LinearLayout(this);
            anuncioLL.setOrientation(LinearLayout.HORIZONTAL);

            LinearLayout anuncioLLFotoTombamento = new LinearLayout(this);
            anuncioLLFotoTombamento.setOrientation(LinearLayout.VERTICAL);
            anuncioLL.addView(anuncioLLFotoTombamento);  // adiciona o LinearLayout "anuncioLLFotoTombamento" no LinearLayout pai

            //TODO: Ver isso
            ImageView anuncioImage = new ImageView(this);
            anuncioImage.setImageDrawable(null); // imagem do objeto do anuncio
            anuncioLLFotoTombamento.addView(anuncioImage);
            //TODO: Ver isso
            TextView anuncioTombamento = new TextView(this);
            anuncioTombamento.setText(null); // tombamento do objeto do anuncio
            anuncioLLFotoTombamento.addView(anuncioTombamento);

            LinearLayout anuncioLLDados = new LinearLayout(this);
            anuncioLLDados.setOrientation(LinearLayout.VERTICAL);
            anuncioLL.addView(anuncioLLDados); // adiciona LinearLayout "anuncioLLDados" no LinearLayout pai

            TextView situacao = new TextView(this);
            anuncioLLDados.addView(situacao);
            TextView interresses = new TextView(this);
            anuncioLLDados.addView(interresses);
            TextView usuario = new TextView(this);
            anuncioLLDados.addView(usuario);

            anunciosSV.addView(anuncioLL); // adiciona o anuncio no ScrollView
        }
    }

}
