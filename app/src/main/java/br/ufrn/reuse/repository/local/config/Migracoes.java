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
            String resourceName = RawResourcesUtils.getResourceName(context, id);
            String nomeArquivoMigracao =  resourceName.replaceAll("br.ufrn.reuse:raw/",""); ;

            if(nomeMigracaoIsValid(nomeArquivoMigracao+".sql")){
                int numVersao = Integer.parseInt(nomeArquivoMigracao.split("_")[0].replaceAll("v",""));

                Migracao migracao = new Migracao(nomeArquivoMigracao,numVersao,id,resourceName);
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

        // sort da menor para a maior versão
        // bubble sort
        for(int index1 = migracoes.size() - 1; index1 > 0 ; index1--) {
            for(int index2 = 0; index2 < migracoes.size(); index2++) {
                if(migracoes.get(index2).getVersao() > migracoes.get(index2 + 1).getVersao()) {
                    Migracao aux =(migracoes.get(index2));
                    migracoes.set(index2, migracoes.get(index2 + 1) );
                    migracoes.set(index2 + 1, aux );
                }
            }
        }

        return migracoes;
    }

    private static boolean nomeMigracaoIsValid(String nomeArquivoMigracao) {
        return nomeArquivoMigracao.matches("v([0-9]+)_([a-zA-Z0-9_\\-\\.]+)\\.(sql)");
    }
}
