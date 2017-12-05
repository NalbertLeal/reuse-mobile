package br.ufrn.reuse.repository.anuncio.local;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;
import br.ufrn.reuse.dominio.anuncio.Etiqueta;
import br.ufrn.reuse.repository.local.config.DataAccessException;
import br.ufrn.reuse.repository.local.config.SqlHelper;

/**
 * Created by Daniel on 10/27/2017.
 */

public class EtiquetaLocalRepository extends LocalRepository{

    public EtiquetaLocalRepository(Context context) {
        super(context);
    }

    public void save(List<Etiqueta> etiquetas){

        SQLiteDatabase database = sqlHelper.getWritableDatabase();

        try {
            database.beginTransaction();
            for(Etiqueta etiqueta : etiquetas) {
                database.execSQL(
                        " INSERT INTO `etiqueta` (`id`, `nome`)" +
                        " VALUES ('" + etiqueta.getId() + "', '" + etiqueta.getNome() + "');");
            }
            database.setTransactionSuccessful();
        } catch (SQLException ex) {
            throw new DataAccessException(ex.getMessage());
        }finally {
            database.endTransaction();
        }
    }

    public void saveByAnuncio(List<Etiqueta> etiquetas, long idAnuncio){

        SQLiteDatabase database = sqlHelper.getWritableDatabase();

        try {
            database.beginTransaction();
            for(Etiqueta etiqueta : etiquetas) {
                database.execSQL(
                        " INSERT INTO `etiquetasAnuncio` (`id_etiqueta`, `id_anuncio`)" +
                        " VALUES ('" + etiqueta.getId() + "', '" + idAnuncio + "');");
            }
            database.setTransactionSuccessful();
        } catch (SQLException ex) {
            throw new DataAccessException(ex.getMessage());
        }finally {
            database.endTransaction();
        }
    }

    public List<Etiqueta> findAllEtiquetas() {

        SQLiteDatabase database = sqlHelper.getReadableDatabase();
        Cursor rs = database.rawQuery("SELECT id, nome FROM etiqueta", null);

        List<Etiqueta> etiquetas = new ArrayList<Etiqueta>();

        while(rs.moveToNext()){
            long id = rs.getLong(1);
            String nome = rs.getString(1);
            Etiqueta etiqueta = new Etiqueta(id, nome);
            etiquetas.add(etiqueta);
        }
        rs.close();
        return etiquetas;
    }

    public List<Etiqueta> findAllEtiquetasByAnuncioId(Long idAnuncio) {

        SQLiteDatabase database = sqlHelper.getReadableDatabase();
        Cursor rs = database.rawQuery(
                    "SELECT etiqueta.id, etiqueta.nome " +
                            "FROM etiquetasAnuncio " +
                            "LEFT JOIN id_etiqueta etiqueta" +
                            "WHERE id_anuncio =" + idAnuncio, null);

        List<Etiqueta> etiquetas = new ArrayList<Etiqueta>();

        while(rs.moveToNext()){
            long id = rs.getLong(1);
            String nome = rs.getString(1);
            Etiqueta etiqueta = new Etiqueta(id, nome);
            etiquetas.add(etiqueta);
        }
        rs.close();
        return etiquetas;
    }
}
