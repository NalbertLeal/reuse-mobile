package br.ufrn.reuse.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

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
        iniciaBarraSuperior("Meus anúncios");

        // seta imagem de usuario
        ImageView fotoUsuario = (ImageView) findViewById(R.id.imageView2);

        //TODO: Recuperar foto REAL do usuário.
        new PegarImagemAnuncio(fotoUsuario).execute("https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAuiAAAAJGMyZmQ1MjgwLTUxYjUtNGFmZC04ZmU4LTc5ODZkZWI0ZTkzOQ.jpg");

        //TODO: Setar informações do usuário logado.
        // seta nome de usuario
        TextView nomeUsuario = (TextView) findViewById(R.id.nome_usuario);
        nomeUsuario.setText("Nabert Gabriel");

        //TODO: Chamar via asyncTask

        ReuseFacadeImpl reuseFacade = new ReuseFacadeImpl(this);
        List<Anuncio> anuncios = reuseFacade.findAllAnunciosPublicados();

        GridView gridViewAnuncios = (GridView) findViewById(R.id.lista_meus_anuncios);
        gridViewAnuncios.setAdapter(new MeusAnunciosAdapter(this, anuncios));
        ((ArrayAdapter) gridViewAnuncios.getAdapter()).notifyDataSetChanged();
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
