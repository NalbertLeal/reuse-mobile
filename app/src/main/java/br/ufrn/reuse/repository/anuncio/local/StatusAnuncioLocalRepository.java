package br.ufrn.reuse.repository.anuncio.local;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import br.ufrn.reuse.dominio.anuncio.StatusAnuncio;
import br.ufrn.reuse.repository.local.config.DataAccessException;

/**
 * Created by Daniel on 10/27/2017.
 */

public class StatusAnuncioLocalRepository extends LocalRepository{
    public StatusAnuncioLocalRepository(Context context) {
        super(context);
    }
    public void save(StatusAnuncio statusAnuncio) {

        SQLiteDatabase database = sqlHelper.getWritableDatabase();

        try {
            database.beginTransaction();
            database.execSQL(
                    " INSERT INTO `status_anuncio` (`id`, `nome`)" +
                            " VALUES ('" + statusAnuncio.getIdentificador() +
                            "', '" + statusAnuncio.getNome() + "');");
            database.setTransactionSuccessful();
        } catch (SQLException ex) {
            throw new DataAccessException(ex.getMessage());
        }finally {
            database.endTransaction();
        }
    }
}
