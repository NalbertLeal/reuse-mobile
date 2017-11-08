package br.ufrn.reuse.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import java.util.logging.Logger;

import br.ufrn.reuse.R;
import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.utils.PegarImagemAnuncio;

/**
 * @author Nalbert Gabriel Melo Leal
 */
public class MeusAnunciosAdapter extends ArrayAdapter<Anuncio> {

    Logger logger = Logger.getLogger(getClass().getName());

    private List<Anuncio> anuncios;

    public MeusAnunciosAdapter(Context context, List<Anuncio> anuncios){
        super(context,0,anuncios);
        this.anuncios = anuncios;
    }

    @NonNull
    public View getView(int position){

        Anuncio anuncio = this.getItem(position);

        View convertView;
        convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.anuncio_meus_anuncios,null);

        ImageView anuncioImage = (ImageView) convertView.findViewById(R.id.imagem_anuncio);

        PegarImagemAnuncio p = new PegarImagemAnuncio(anuncioImage);
        p.execute("https://i0.wp.com/ricardohage.com.br/wp-content/uploads/2017/04/computadores_0006_desktop.jpg?resize=800%2C445");

        TextView tombamento = (TextView) convertView.findViewById(R.id.anuncio_tombamento);
        tombamento.setText("SituaÃ§Ã£o: " + anuncio.getBem().getNumTombamento());

        TextView situacao = (TextView) convertView.findViewById(R.id.anuncio_situacao);
        situacao.setText("Situacao: " + anuncio.getBem().getNumTombamento());

        TextView unidade = (TextView) convertView.findViewById(R.id.anuncio_interresse);
        unidade.setText("Unidade: " + anuncio.getBem().getNumTombamento());

        TextView interresses = (TextView) convertView.findViewById(R.id.anuncio_unidade);
        interresses.setText("Interesses: " + anuncio.getBem().getNumTombamento());

        return convertView;
    }

}