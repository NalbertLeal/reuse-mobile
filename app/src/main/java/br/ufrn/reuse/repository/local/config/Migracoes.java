package br.ufrn.reuse.repository.local.config;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.ufrn.reuse.utils.IOUtils;
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

            content = IOUtils.toString(fileStream);

            fileStream.close();

            content = content.replaceAll("\n","").replaceAll("\r","");
            return content;
        }
        catch(IOException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    private static boolean nomeMigracaoIsValid(String nomeArquivoMigracao) {
        return nomeArquivoMigracao.matches("v([0-9]+)_([a-zA-Z0-9_\\-\\.]+)\\.(sql)");
    }
}
