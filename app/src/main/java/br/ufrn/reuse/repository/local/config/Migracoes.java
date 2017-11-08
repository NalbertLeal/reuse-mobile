package br.ufrn.reuse.repository.local.config;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.reuse.utils.RawResourcesUtils;

/**
 * Created by Daniel on 11/7/2017.
 */
public class Migracoes {

    public static List<Migracao> getMigracoes(int versaoMinima, Context context){
        List<Migracao> migracoes = new ArrayList<>();

        for (Integer id : RawResourcesUtils.getRawResourcesIds()) {
            String nomeArquivoMigracao = RawResourcesUtils.getResourceName(context,id);

            if(nomeMigracaoIsValid(nomeArquivoMigracao)){
                int numVersao = Integer.parseInt(nomeArquivoMigracao.split("_")[0].replaceAll("v",""));

                Migracao migracao = new Migracao(nomeArquivoMigracao,numVersao);
                if(!migracoes.contains(migracao)) {
                    migracoes.add(migracao);
                }else{
                    int indiceMigracaoConflitante = migracoes.indexOf(migracao);
                    throw new MigracaoDuplicadaException("Não deve existir duas migrações com a mesma versão. Migrações conflitantes: "
                            + migracoes.get(indiceMigracaoConflitante).getNomeArquivo()
                            + " e "+migracao.getNomeArquivo());
                }

            }

        }

        //TODO: Ordenar as versões em ordem crescente

        return migracoes;
    }

    private static boolean nomeMigracaoIsValid(String nomeArquivoMigracao) {
        return nomeArquivoMigracao.matches("v([0-9]+)_([a-zA-Z0-9_\\-\\.]+)\\.(sql)");
    }
}
