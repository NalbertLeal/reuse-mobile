package br.ufrn.reuse.repository.anuncio.local;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;
import br.ufrn.reuse.repository.local.config.DataAccessException;

/**
 * Created by Daniel on 10/27/2017.
 */

public class CategoriaLocalRepository extends LocalRepository{

    public CategoriaLocalRepository(Context context) {
        super(context);
    }


    public CategoriaAnuncio findCategoriaById(String idCategoria) {

        SQLiteDatabase database = sqlHelper.getWritableDatabase();
        return null;
    }

    public void save(List<CategoriaAnuncio> categorias) {

        SQLiteDatabase database = sqlHelper.getWritableDatabase();

        try {
            database.beginTransaction();
            for (CategoriaAnuncio cat : categorias) {
                database.execSQL(
                        "            INSERT INTO `categoria_anuncio` (`id`, `descricao`)" +
                        "            VALUES ('" + cat.getIdentificador() + "', '" + cat.getDescricao() + "');");
            }
            database.setTransactionSuccessful();
        } catch (SQLException ex) {
            throw new DataAccessException(ex.getMessage());
        }finally {
            database.endTransaction();
        }
    }

    public List<CategoriaAnuncio> findAllCategorias() {
        SQLiteDatabase database = sqlHelper.getReadableDatabase();
        Cursor rs = database.rawQuery("SELECT id, descricao FROM categoria_anuncio", null);

        List<CategoriaAnuncio> categorias = new ArrayList<CategoriaAnuncio>();

        while(rs.moveToNext()){
            String id = rs.getString(0);
            String descricao = rs.getString(1);
            CategoriaAnuncio categoria = new CategoriaAnuncio(id, descricao);
            categorias.add(categoria);
        }
        rs.close();
        return categorias;
    }
}
