package br.ufrn.reuse.remote.factory;

import android.content.Context;

import br.ufrn.reuse.remote.comum.UnidadeRemoteService;
import br.ufrn.reuse.remote.comum.UsuarioRemoteService;
import br.ufrn.reuse.remote.comum.impl.UnidadeRemoteServiceImpl;
import br.ufrn.reuse.remote.comum.impl.UsuarioRemoteServiceImpl;
import br.ufrn.reuse.remote.patrimonio.BemRemoteService;
import br.ufrn.reuse.remote.patrimonio.BemRemoteServiceImpl;

/**
 * Created by Daniel on 11/28/2017.
 */

public class APISinfoServiceFactoryImpl implements APISinfoServiceFactory{

    private static APISinfoServiceFactoryImpl apiSinfoServiceFactory;

    @Override
    public BemRemoteService createBemRemoteService(Context context) {
        return new BemRemoteServiceImpl(context);
    }

    @Override
    public UnidadeRemoteService createUnidadeRemoteService(Context context) {
        return new UnidadeRemoteServiceImpl(context);
    }

    @Override
    public UsuarioRemoteService createUsuarioRemoteService(Context context) {
        return new UsuarioRemoteServiceImpl(context);
    }

    public static APISinfoServiceFactoryImpl getInstance(){
        if(apiSinfoServiceFactory == null){
            APISinfoServiceFactoryImpl apiSinfoServiceFactory = new APISinfoServiceFactoryImpl();
        }

        return apiSinfoServiceFactory;
    }

}
