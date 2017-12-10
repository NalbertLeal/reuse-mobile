package br.ufrn.reuse.activity.interesses;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import br.ufrn.reuse.R;
import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.utils.PegarImagemAnuncio;

/**
 * Created by adelinofernandes on 30/10/2017.
 */

public class InteressesListAdapter extends ArrayAdapter<Anuncio>{

    private Logger logger  = Logger.getLogger(getClass().getName());
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


        PegarImagemAnuncio pegarImg = new PegarImagemAnuncio(imageView);

        List<String> urlFotosMock = Arrays.asList("https://i4.zst.com.br/images/imac-apple-intel-core-i5-2-80-ghz-8-gb-hd-1-tb-intel-iris-pro-graphics-os-x-el-capitan-mk442bz-a-photo75677443-45-37-36.jpg", "https://images.etna.com.br/produtos/95/373995/373995_ampliada.jpg","https://i0.wp.com/ricardohage.com.br/wp-content/uploads/2017/04/computadores_0006_desktop.jpg?resize=800%2C445","https://http2.mlstatic.com/D_Q_NP_984415-MLB25225395850_122016-Q.jpg");
        Random r= new Random();
        int randomNumber = (r.nextInt() % urlFotosMock.size());
        if(randomNumber < 0) {
            randomNumber = randomNumber * -1;
        }
        pegarImg.execute(urlFotosMock.get(randomNumber));



        //imageView.setImageResource(R.drawable.ic_menu_gallery);




        TextView datalabel = (TextView) convertView.findViewById(R.id.data_label);
        datalabel.setText("10/12/2017");

        TextView situacaolabel = (TextView) convertView.findViewById(R.id.situacao_label);
        situacaolabel.setText("ANUNCIADO");


        TextView usuariolabel = (TextView) convertView.findViewById(R.id.nomelabel);
        usuariolabel.setText("---");

        return convertView;
    }

}

