package br.ufrn.reuse.repository.anuncio.local;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import br.ufrn.reuse.repository.local.config.DataAccessException;
import br.ufrn.reuse.repository.local.config.SqlHelper;

/**
 * Created by Tek on 03/12/2017.
 */

public class LocalRepository {
    protected final Context context;
    protected SqlHelper sqlHelper;

    public LocalRepository(Context context) {
        this.context = context;
        this.sqlHelper = new SqlHelper(context);
    }

    protected void delete(String tabela, Long id) {

        SQLiteDatabase database = sqlHelper.getWritableDatabase();

        try {
            database.beginTransaction();
            database.execSQL("DELETE FROM " + tabela + " WHERE id == " + id + " ;");
            database.setTransactionSuccessful();
        } catch (SQLException ex) {
            throw new DataAccessException(ex.getMessage() + ". Não utilize esse método para este tipo de objeto");
        }finally {
            database.endTransaction();
        }
    }
}
