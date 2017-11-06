package br.ufrn.reuse.remote.anuncio;

import android.content.Context;

import java.util.Arrays;
import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Foto;

/**
 * Created by Daniel on 11/5/2017.
 */

public class FotoRemoteService {

    private final List<Foto> fotos;
    private final Context context;

    public FotoRemoteService(Context context){
        this.context = context;

        this.fotos = Arrays.asList(new Foto(1L, 1L, "http://www.ubadecormoveis.com.br/loja/wp-content/uploads/2017/07/Cadeira-Gr%C3%A9cia-CAS-Suede-Amassado-chocolate-800x600.jpg", true),
                new Foto(2L, 2L, "http://www.ubadecormoveis.com.br/loja/wp-content/uploads/2017/07/Cadeira-Gr%C3%A9cia-CAS-Suede-Amassado-chocolate-800x600.jpg", false),
                new Foto(3L, 3L, "http://www.ubadecormoveis.com.br/loja/wp-content/uploads/2017/07/Cadeira-Gr%C3%A9cia-CAS-Suede-Amassado-chocolate-800x600.jpg", false),
                new Foto(4L, 4L, "http://www.ubadecormoveis.com.br/loja/wp-content/uploads/2017/07/Cadeira-Gr%C3%A9cia-CAS-Suede-Amassado-chocolate-800x600.jpg", false));

    }

    public List<Foto> findAllFotosByAnuncioId(Long id) {
        return this.fotos;
    }
}
