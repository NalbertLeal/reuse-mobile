package br.ufrn.reuse.repository.local.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

/**
 * Created by Daniel on 10/25/2017.
 */
public class SqlHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "reuse";

    private Context context;

    public SqlHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
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
        List<Migracao> migracoes = Migracoes.getMigracoes(versaoAntiga, context);

        for (Migracao migracao : migracoes) {
            if(migracao.getVersao() > versaoAntiga){
                migracao.aplicar(database);
            }
        }

    }
}
