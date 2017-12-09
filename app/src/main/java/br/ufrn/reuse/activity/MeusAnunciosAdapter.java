package br.ufrn.reuse.activity;

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
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent){

        Anuncio anuncio = this.anuncios.get(position);

        convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.anuncio_meus_anuncios,null);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imagem_anuncio);

        //TODO: Tirar isso
        PegarImagemAnuncio pegarImg = new PegarImagemAnuncio(imageView);
        List<String> urlFotosMock = Arrays.asList("http://www.pokerproductos.com/WebRoot/StoreES/Shops/61976209/4D3F/07EA/8A46/F9B0/3645/C0A8/29BB/BFC4/Mesa_de_poker_redonda_CAIMAN_OCIO_negra_c.jpg", "https://images.etna.com.br/produtos/95/373995/373995_ampliada.jpg","https://i0.wp.com/ricardohage.com.br/wp-content/uploads/2017/04/computadores_0006_desktop.jpg?resize=800%2C445","https://http2.mlstatic.com/D_Q_NP_984415-MLB25225395850_122016-Q.jpg");
        Random r= new Random();
        int randomNumber = (r.nextInt() % urlFotosMock.size());
        if(randomNumber < 0) {
            randomNumber = randomNumber * -1;
        }
        pegarImg.execute(urlFotosMock.get(randomNumber));

        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // v.getContext().startActivity(new Intent(v.getContext(), NomeDaActivityDeAnuncio.class));
            }
        });

        TextView tombamento = (TextView) convertView.findViewById(R.id.anuncio_tombamento);
        tombamento.setText("Tombamento: " + anuncio.getBem().getNumTombamento());

        TextView situacao = (TextView) convertView.findViewById(R.id.anuncio_situacao);
        situacao.setText("Situacao: " + anuncio.getStatusAnuncio());

        TextView unidade = (TextView) convertView.findViewById(R.id.anuncio_interresse);
        unidade.setText("Interesses: " + anuncio.getBem().getNumTombamento());

        TextView interresses = (TextView) convertView.findViewById(R.id.anuncio_unidade);
        interresses.setText("Unidade: " + anuncio.getUnidade());

        return convertView;

        /*
        Anuncio anuncio = this.getItem(position);

        View convertView;
        convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.anuncio_meus_anuncios,null);

        ImageView anuncioImage = (ImageView) convertView.findViewById(R.id.imagem_anuncio);

        PegarImagemAnuncio p = new PegarImagemAnuncio(anuncioImage);
        p.execute("https://i0.wp.com/ricardohage.com.br/wp-content/uploads/2017/04/computadores_0006_desktop.jpg?resize=800%2C445");

        TextView tombamento = (TextView) convertView.findViewById(R.id.anuncio_tombamento);
        tombamento.setText("Tombamento: " + anuncio.getBem().getNumTombamento());

        TextView situacao = (TextView) convertView.findViewById(R.id.anuncio_situacao);
        situacao.setText("Situacao: " + anuncio.getStatusAnuncio());

        TextView unidade = (TextView) convertView.findViewById(R.id.anuncio_interresse);
        unidade.setText("Interesses: " + anuncio.getBem().getNumTombamento());

        TextView interresses = (TextView) convertView.findViewById(R.id.anuncio_unidade);
        interresses.setText("Unidade: " + anuncio.getUnidade());

        return convertView;

        */
    }

}