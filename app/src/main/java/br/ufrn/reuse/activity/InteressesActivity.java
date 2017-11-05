package br.ufrn.reuse.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.List;

import br.ufrn.reuse.R;
import br.ufrn.reuse.activity.vitrine.VitrineListAdapter;
import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.facade.ReuseFacadeImpl;

public class InteressesActivity extends AbstractActivity {
    private String[] situacao = new String[] {"Todos", "Em análise", "Aprovados", "Aguardando aprovação"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interesses);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, situacao);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.situacao);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        List<Anuncio> anuncios = new ReuseFacadeImpl(this).findAllAnunciosPublicados();
        GridView listView = (GridView) findViewById(R.id.lista_interesses);
        listView.setAdapter(new VitrineListAdapter(this, anuncios));

        LinearLayout interessesLayout = (LinearLayout) findViewById(R.id.layout_interesses);

        int widthIntereesses = interessesLayout.getWidth();


        listView.setMinimumWidth(widthIntereesses);
    }
}
