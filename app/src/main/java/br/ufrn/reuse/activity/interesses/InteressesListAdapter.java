package br.ufrn.reuse.activity.interesses;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import br.ufrn.reuse.R;
import br.ufrn.reuse.dominio.anuncio.Anuncio;

/**
 * Created by adelinofernandes on 30/10/2017.
 */

public class InteressesListAdapter extends ArrayAdapter<Anuncio>{

    private List<Anuncio> anuncios;

    public InteressesListAdapter(Context context, List<Anuncio> anuncios){
        super(context,0,anuncios);
        this.anuncios = anuncios;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent){

        Anuncio anuncio = this.getItem(position);

        convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.item_interesses,null);




        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewinteresses);
        imageView.setImageResource(R.drawable.ic_menu_gallery);




        TextView datalabel = (TextView) convertView.findViewById(R.id.data_label);
        datalabel.setText("DATAMOCADA");

        TextView situacaolabel = (TextView) convertView.findViewById(R.id.situacao_label);
        situacaolabel.setText("SITUACAOMOCADA");


        TextView usuariolabel = (TextView) convertView.findViewById(R.id.nomelabel);
        usuariolabel.setText("NOMEMOCADO");

        return convertView;
    }

}

