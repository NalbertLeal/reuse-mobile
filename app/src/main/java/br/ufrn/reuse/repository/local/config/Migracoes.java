package br.ufrn.reuse.repository.local.config;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.ufrn.reuse.utils.RawResourcesUtils;

/**
 * Created by Daniel on 11/7/2017.
 */
public class Migracoes {

    public static List<Migracao> getMigracoes(Context context){
        List<Migracao> migracoes = new ArrayList<>();

        for (Integer id : RawResourcesUtils.getRawResourcesIds()) {
            String resourceName = RawResourcesUtils.getResourceName(context, id);
            String nomeArquivoMigracao =  resourceName.replaceAll("br.ufrn.reuse:raw/",""); ;
            if(nomeMigracaoIsValid(nomeArquivoMigracao+".sql")){
                int numVersao = Integer.parseInt(nomeArquivoMigracao.split("_")[0].replaceAll("v",""));

                Migracao migracao = new Migracao(nomeArquivoMigracao,numVersao,id,resourceName, getResourceSql(context,id));
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

        Collections.sort(migracoes);

        return migracoes;
    }

    private static String getResourceSql(Context context, int resourceId){
        try {
            InputStream fileStream = context.getResources().openRawResource(resourceId);

            int line;
            String content = "";

                while((line = fileStream.read()) != -1) {
                    content += (char) line;
                }

            fileStream.close();

            return content;
        }
        catch(IOException e) {
            throw new DataAcessException(e.getMessage());
        }
    }

    private static boolean nomeMigracaoIsValid(String nomeArquivoMigracao) {
        return nomeArquivoMigracao.matches("v([0-9]+)_([a-zA-Z0-9_\\-\\.]+)\\.(sql)");
    }
}
