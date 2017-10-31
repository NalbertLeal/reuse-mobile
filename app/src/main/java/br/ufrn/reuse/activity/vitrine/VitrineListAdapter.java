package br.ufrn.reuse.activity.vitrine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.ufrn.reuse.R;
import br.ufrn.reuse.dominio.anuncio.Anuncio;

/**
 * Created by adelinofernandes on 30/10/2017.
 */

public class VitrineListAdapter extends ArrayAdapter<Anuncio>{

    private List<Anuncio> anuncios;

    public VitrineListAdapter(Context context, List<Anuncio> anuncios){
        super(context,0,anuncios);
        this.anuncios = anuncios;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        Anuncio anuncio = this.getItem(position);

        convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.item_vitrine,null);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView2);
        imageView.setImageResource(R.drawable.ic_logo_reuse);

        TextView textView = (TextView) convertView.findViewById(R.id.textView2);
        textView.setText("Eita boe");


        TextView textView2 = (TextView) convertView.findViewById(R.id.textView2);
        textView2.setText("Eita porrra");

        return convertView;
    }

}
