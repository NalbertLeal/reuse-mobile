package br.ufrn.reuse.remote;

import br.ufrn.reuse.remote.factory.APISinfoServiceFactory;
import br.ufrn.reuse.remote.factory.APISinfoServiceFactoryImpl;
import br.ufrn.reuse.remote.factory.APISinfoServiceFactorySimulated;
import br.ufrn.reuse.remote.factory.ReuseServiceFactory;
import br.ufrn.reuse.remote.factory.ReuseServiceFactorySimulation;

/**
 * Created by Daniel on 11/28/2017.
 */

public class RemoteServiceConfig {

    private static final String API_SINFO_FACTORY = "IMPLEMENTACAO";
    private static final String REUSE_FACTORY = "SIMULACAO";

    public static APISinfoServiceFactory getAPISinfoServiceFactory(){

        switch (API_SINFO_FACTORY){
            case "IMPLEMENTACAO":
                return APISinfoServiceFactoryImpl.getInstance();
            case "SIMULACAO":
                return APISinfoServiceFactorySimulated.getInstance();
            default:
                throw new IllegalStateException("Deve ser configurada o acesso aos serviços para alguma implemntação existente");
        }

    }

    public static ReuseServiceFactory getReuseServiceFactory(){
        return new ReuseServiceFactorySimulation();
    }

}
