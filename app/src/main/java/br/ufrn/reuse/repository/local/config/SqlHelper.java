package br.ufrn.reuse.repository.local.config;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.IOException;
import java.util.List;

/**
 * Created by Daniel on 10/25/2017.
 */
public class SqlHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "reuse";

    private Context context;

    public SqlHelper(Context context) {
        super(context, DATABASE_NAME, null, getVersion(context));
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        migrarParaUltimaVersao(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        migrarParaUltimaVersao(database,oldVersion);
    }

    private void migrarParaUltimaVersao(SQLiteDatabase database) {
        migrarParaUltimaVersao(database, 0);
    }

    /**
     * Efetua a migração do banco de dadox para a versão mais atual.
     *
     * @param database
     * @param versaoAntiga
     */
    private void migrarParaUltimaVersao(SQLiteDatabase database, int versaoAntiga) {
        List<Migracao> migracoes = Migracoes.getMigracoes(context);

        int versaoAplicada = 0;

        try{
            database.beginTransaction();

            for (Migracao migracao : migracoes) {
                if(migracao.getVersao() > versaoAntiga){
                    versaoAplicada = migracao.getVersao();
                    String sqlMigracao = migracao.getSqlMigracao();

                    if(sqlMigracao != null && !sqlMigracao.isEmpty()) {
                        database.execSQL(sqlMigracao);
                    }

                }
            }

            database.setTransactionSuccessful();
        }catch (SQLException exception){
            throw new DataAccessException("Erro ao efetuar migração da base de dados para a versão "+versaoAplicada);
        }catch (IOException ex){
            throw new DataAccessException("Erro ao recuperar os dados do arquivo de migração.");
        }finally {
            database.endTransaction();
        }

    }

    /**
     *
     * @param context
     * @return
     */
    private static int getVersion(Context context) {

        List<Migracao> migracoes = Migracoes.getMigracoes(context);

        if(!migracoes.isEmpty()){
            return migracoes.get(migracoes.size()-1).getVersao();
        }

        return 1;
    }

}
