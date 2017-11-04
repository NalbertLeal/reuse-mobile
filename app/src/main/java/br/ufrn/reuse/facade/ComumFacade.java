package br.ufrn.reuse.facade;

import android.content.Context;

/**
 * Created by Daniel on 11/3/2017.
 */

public class ComumFacade {

    public ComumFacade(Context context) {

    }

    public boolean autenticar() {
        return true; //new ComumRemoteService().credenciaisValidas(usuario, senha);
    }

}
