package br.ufrn.reuse.repository.patrimonio.local;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import br.ufrn.reuse.dominio.patrimonio.Bem;
import br.ufrn.reuse.repository.local.config.DataAccessException;
import br.ufrn.reuse.repository.local.config.SqlHelper;

/**
 * Created by nalbertg on 26/10/17.
 */

public class BemLocalRepository {

    private final Context context;
    private SqlHelper sqlHelper;

    public BemLocalRepository(Context context) {
        this.context = context;
        this.sqlHelper = new SqlHelper(context);
    }

    public Bem findBemById(Long idBem) {

        SQLiteDatabase database = sqlHelper.getWritableDatabase();
        return null;

    }

    public void save(Bem bem) {

        SQLiteDatabase database = sqlHelper.getWritableDatabase();

        try {
            database.beginTransaction();
            database.execSQL("");
            database.setTransactionSuccessful();
        } catch (SQLException ex) {
            throw new DataAccessException(ex.getMessage());
        }finally {
            database.endTransaction();
        }

    }
}
