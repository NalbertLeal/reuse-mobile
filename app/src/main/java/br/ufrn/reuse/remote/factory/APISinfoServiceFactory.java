package br.ufrn.reuse.remote.factory;

import android.content.Context;

import br.ufrn.reuse.remote.comum.UnidadeRemoteService;
import br.ufrn.reuse.remote.comum.UsuarioRemoteService;
import br.ufrn.reuse.remote.patrimonio.BemRemoteService;

/**
 * Created by Daniel on 11/28/2017.
 */

public interface APISinfoServiceFactory {

    BemRemoteService createBemRemoteService(Context context);

    UnidadeRemoteService createUnidadeRemoteService(Context context);

    UsuarioRemoteService createUsuarioRemoteService(Context context);
}
