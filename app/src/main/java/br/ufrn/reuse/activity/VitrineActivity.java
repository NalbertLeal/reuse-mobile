package br.ufrn.reuse.activity;
import br.ufrn.reuse.R;
import br.ufrn.reuse.activity.vitrine.VitrineListAdapter;
import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.facade.ReuseFacadeImpl;

import android.app.Activity;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import java.util.List;

public class VitrineActivity extends AbstractActivity{

    private ReuseFacadeImpl reuseFacade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitrine);

        this.reuseFacade = new ReuseFacadeImpl(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        List<Anuncio> anuncios = reuseFacade.findAllAnunciosPublicados();

        GridView gridVitrine = getGridVitrine();
        gridVitrine.setAdapter(new VitrineListAdapter(this, anuncios));
        //Recupera o usuario logado e o mostra
        recuperaUsuarioUnidade();

        GridView listView = (GridView) findViewById(R.id.lista_vitrine);
        listView.setAdapter(new VitrineListAdapter(this, anuncios));

        Button buttonBucar = (Button) findViewById(R.id.button_buscar);

        buttonBucar.setOnClickListener((view) -> {
            buscar(view);
        });
    }

    private void buscar(View view) {
        EditText editTextBusca = (EditText) findViewById(R.id.text_busca);

        String textoBusca = editTextBusca.getText().toString();

        if(textoBusca != null && !textoBusca.isEmpty()){
            updateConteudoVitrine(reuseFacade.findAllAnunciosPublicados(textoBusca));
        }

    }

    private void updateConteudoVitrine(List<Anuncio> anunciosPublicados) {
        if(anunciosPublicados != null) {

            TextView textView = (TextView) findViewById(R.id.quantidade_resultados);
            textView.setText(anunciosPublicados.size() + " Anúncio(s) encontradas");

            VitrineListAdapter adapter = (VitrineListAdapter) getGridVitrine().getAdapter();
            adapter.clear();
            adapter.addAll(anunciosPublicados);
            adapter.notifyDataSetChanged();

        }
    }

    private void recuperaUsuarioUnidade() {

        Long idUsuario = getIntent().getLongExtra("usuarioLogado", 0);
        Usuario usuarioLogado = new ReuseFacadeImpl(this).findUsuario(idUsuario);
        TextView nome = (TextView) findViewById(R.id.textUser);
        if(nome != null)
            nome.setText(usuarioLogado.getPessoa().getNome());
        TextView email = (TextView) findViewById(R.id.textEmailUser);
        if(email != null)
            email.setText(usuarioLogado.getEmail());

        Long unidadeLogada = getIntent().getLongExtra("unidadeLogada", 0);
        TextView unidade = (TextView) findViewById(R.id.textEmailUser);
        if(unidade != null && unidadeLogada >= 0)
            unidade.setText(unidadeLogada.toString());
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.vitrine, menu);
        return true;
    }

    public void salvarUnidadeUltimoLogado(Long unidade) {
        SharedPreferences sp = getPreferences(Activity.MODE_PRIVATE);
        SharedPreferences.Editor  editor = sp.edit();
        editor.putLong("unidadeUltimoLogado", unidade);
    }

    private GridView getGridVitrine() {
        return (GridView) findViewById(R.id.lista_vitrine);
    }

}
