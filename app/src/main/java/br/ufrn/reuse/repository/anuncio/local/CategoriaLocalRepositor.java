package br.ufrn.reuse.repository.anuncio.local;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;
import br.ufrn.reuse.repository.local.config.DataAcessException;
import br.ufrn.reuse.repository.local.config.SqlHelper;

/**
 * Created by Daniel on 10/27/2017.
 */

public class CategoriaLocalRepositor {

    private final Context context;
    private SqlHelper sqlHelper;

    public CategoriaLocalRepositor(Context context) {
        this.context = context;
        this.sqlHelper = new SqlHelper(context);
    }


    public CategoriaAnuncio findCategoriaById(String idBem) {

        SQLiteDatabase database = sqlHelper.getWritableDatabase();
        return null;

    }

    public void save(CategoriaAnuncio cat) {

        SQLiteDatabase database = sqlHelper.getWritableDatabase();

        try {
            database.beginTransaction();
            database.execSQL("");
            database.setTransactionSuccessful();
        } catch (SQLException ex) {
            throw new DataAcessException(ex.getMessage());
        }finally {
            database.endTransaction();
        }

    }
}
