package br.ufrn.reuse.activity;
import br.ufrn.reuse.R;
import br.ufrn.reuse.activity.vitrine.VitrineListAdapter;
import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.facade.ReuseFacadeImpl;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

import android.drm.DrmStore;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VitrineActivity extends AbstractActivity{

    private List<CategoriaAnuncio> allCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitrine);

        reuseFacade = new ReuseFacadeImpl(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Recupera o usuario logado e o mostra
        recuperaUsuarioUnidade();

        geraCategorias();
        
        List<Anuncio> anuncios = reuseFacade.findAllAnunciosPublicados();

        GridView gridVitrine = getGridVitrine();
        gridVitrine.setAdapter(new VitrineListAdapter(this, anuncios));

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

            atualizaClickItensVitrine();
        }
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

    public void geraCategorias(){

        allCategorias = new ReuseFacadeImpl(this).findAllCategorias();
        LinearLayout categoriasLayout = (LinearLayout) findViewById(R.id.checkboxCategorias);

        for(CategoriaAnuncio cat : allCategorias){
            CheckBox checkCategoria = new CheckBox(this);
            checkCategoria.setText(cat.getDescricao());
            categoriasLayout.addView(checkCategoria);
        }

        for (int i = 0; i < categoriasLayout.getChildCount(); i++) {
            if (categoriasLayout.getChildAt(i) instanceof CheckBox) {
                CheckBox catCheck = (CheckBox) categoriasLayout.getChildAt(i);
                catCheck.setOnClickListener((view) -> {
                    List<CategoriaAnuncio> categoriasSelecionadas = getCategoriasSelecionadas(categoriasLayout);
                    updateConteudoVitrine(reuseFacade.findAllAnunciosPublicadosCategorias(categoriasSelecionadas));
                });
            }
        }
    }

    private List<CategoriaAnuncio> getCategoriasSelecionadas(LinearLayout categoriasLayout) {
        List<CategoriaAnuncio> categoriasSelecionadas = new ArrayList<CategoriaAnuncio>();

        for (int i = 0; i < categoriasLayout.getChildCount(); i++){
            if(categoriasLayout.getChildAt(i) instanceof CheckBox) {
                CheckBox catCheck = (CheckBox) categoriasLayout.getChildAt(i);
                if (catCheck.isChecked()) {
                    for (CategoriaAnuncio cat : allCategorias) {
                        if (cat.getDescricao().equals(catCheck.getText().toString())) {
                            categoriasSelecionadas.add(cat);
                        }
                    }
                }
            }
        }

        return categoriasSelecionadas;
    }

    private void atualizaClickItensVitrine(){

        getGridVitrine().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object listItem = getGridVitrine().getItemAtPosition(position);
                if(listItem instanceof Anuncio){
                    iniciaAnuncioView(((Anuncio)listItem).getId());
                }
                logger.log(Level.SEVERE, ">>> clicou");
            }
        });
    }

    private void iniciaAnuncioView(Long idAnuncio){
        Intent intent = new Intent(this, AnuncioViewActivity.class);
        intent.putExtra("idAnuncio", idAnuncio);
        startActivity(intent);
    }

    private GridView getGridVitrine() {
        return (GridView) findViewById(R.id.lista_vitrine);
    }

}
