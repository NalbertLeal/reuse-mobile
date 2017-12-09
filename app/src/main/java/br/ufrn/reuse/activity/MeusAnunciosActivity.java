package br.ufrn.reuse.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import br.ufrn.reuse.R;
import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.facade.ReuseFacadeImpl;
import br.ufrn.reuse.utils.PegarImagemAnuncio;

/**
 * Created by nalbertg on 07/11/2017.
 */

public class MeusAnunciosActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_anuncios);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Meus anúncios");

        // seta imagem de usuario
        ImageView fotoUsuario = (ImageView) findViewById(R.id.imageView2);

        PegarImagemAnuncio p = new PegarImagemAnuncio(fotoUsuario);
        List<String> urlFotosMock = Arrays.asList("https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAuiAAAAJGMyZmQ1MjgwLTUxYjUtNGFmZC04ZmU4LTc5ODZkZWI0ZTkzOQ.jpg");
        Random r= new Random();
        int randomNumber = (r.nextInt() % urlFotosMock.size());
        if(randomNumber < 0) {
            randomNumber = randomNumber * -1;
        }
        p.execute(urlFotosMock.get(randomNumber));

        // seta nome de usuario

        TextView nomeUsuario = (TextView) findViewById(R.id.nome_usuario);
        nomeUsuario.setText("Nabert Gabriel");

        //List<Anuncio> anuncios = reuseFacade.findAllAnunciosPublicados();
        ReuseFacadeImpl reuseFacade = new ReuseFacadeImpl(this);
        List<Anuncio> anuncios = reuseFacade.findAllAnunciosPublicados();
        MeusAnunciosAdapter adapter = new MeusAnunciosAdapter(this, anuncios);

        //LinearLayout linearLayoutMeusAnuncios = (LinearLayout) findViewById(R.id.linear_layout_meus_anuncios);
        //for (int i = 0; i < anuncios.size(); i++) {
        //    linearLayoutMeusAnuncios.addView(adapter.getView(this, anuncios));
        //}

        GridView gv = (GridView) findViewById(R.id.lista_meus_anuncios);
        gv.setAdapter(adapter);
        ((MeusAnunciosAdapter)gv.getAdapter()).notifyDataSetChanged();
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
