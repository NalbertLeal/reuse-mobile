package br.ufrn.reuse.repository.local.config;

import android.content.Context;

import java.util.ArrayList;
import java.util.Comparator;
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

        // sort da menor para a maior versão
        //Selection Sort
        ArrayList<Migracao> migracoesOrd = new ArrayList<>();
        for(int i=0; i < migracoes.size()-1; i++){
            Migracao min = migracoes.get(i);
            for(int j = i+1; j < migracoes.size(); j++){
                if(migracoes.get(j).getVersao() < min.getVersao()){
                    min = migracoes.get(j);
                }
            }
            migracoesOrd.add(min);
        }
        migracoes = migracoesOrd;
        return migracoes;
    }

    private static boolean nomeMigracaoIsValid(String nomeArquivoMigracao) {
        return nomeArquivoMigracao.matches("v([0-9]+)_([a-zA-Z0-9_\\-\\.]+)\\.(sql)");
    }
}
