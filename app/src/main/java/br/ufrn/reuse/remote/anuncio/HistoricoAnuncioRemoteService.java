package br.ufrn.reuse.remote.anuncio;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.HistoricoAnuncio;
import br.ufrn.reuse.dominio.anuncio.StatusAnuncio;
import br.ufrn.reuse.dominio.comum.Usuario;

/**
 * Created by Daniel on 11/5/2017.
 */

public class HistoricoAnuncioRemoteService {

    private final List<HistoricoAnuncio> historicoAnuncios;
    private final Context context;

    public HistoricoAnuncioRemoteService(Context context){
        this.context = context;

        this.historicoAnuncios = Arrays.asList(new HistoricoAnuncio(1L, null, new StatusAnuncio("CADASTRADO","Cadastrado"), new Date(), new Usuario(), ""));
    }

    public List<HistoricoAnuncio> findAllHistoricosByAnuncioId(Long id) {

        List<HistoricoAnuncio> historicos = new ArrayList<>();

        for (HistoricoAnuncio historicoAnuncio : this.historicoAnuncios){
            historicoAnuncio.setAnuncio(new Anuncio(id));
            historicos.add(historicoAnuncio);
        }

        return historicos;
    }
}
