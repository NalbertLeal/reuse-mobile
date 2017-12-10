package br.ufrn.reuse.repository.anuncio.local;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.Interesse;
import br.ufrn.reuse.dominio.comum.Usuario;
import br.ufrn.reuse.repository.local.config.DataAccessException;
import br.ufrn.reuse.utils.DateFormatUtils;

/**
 * Created by Daniel, Esther on 10/27/2017.
 */

public class InteresseLocalRepository extends LocalRepository {
    public InteresseLocalRepository(Context context) {
        super(context);
    }

    public List<Interesse> findAllInteressesByAnuncioId(Long idAnuncio) {

        SQLiteDatabase database = sqlHelper.getReadableDatabase();
        Cursor rs = database.rawQuery(
                "SELECT id, id_interessado, data_interesse, id_anuncio, data_aprovacao " +
                "FROM Interesse " +
                "WHERE id_anuncio =" + idAnuncio, null);

        List<Interesse> interesses = new ArrayList<Interesse>();

        while(rs.moveToNext()){
            Interesse inter = new Interesse();
            inter.setId(rs.getLong(0));
            inter.setInteressado(new Usuario(rs.getLong(1)));
            inter.setDataInteresse(DateFormatUtils.stringToDate(rs.getString(2)));
            inter.setAnuncio(new Anuncio(rs.getLong(0)));
            inter.setDataAprovacao(DateFormatUtils.stringToDate(rs.getString(3)));
            interesses.add(inter);
        }
        rs.close();
        return interesses;
    }

    public void save(Interesse interesse) {

        SQLiteDatabase database = sqlHelper.getWritableDatabase();

        try {
            database.beginTransaction();
            database.execSQL(
                    " INSERT INTO `Interesse` (`id`, id_interessado, data_interesse, data_aprovacao)" +
                            " VALUES ('" + interesse.getId() +
                            "', '" + interesse.getInteressado().getId() +
                            "', '" + DateFormatUtils.dateToString(interesse.getDataInteresse()) +
                            "', '" + DateFormatUtils.dateToString(interesse.getDataAprovacao()) + "');");
            database.setTransactionSuccessful();
        } catch (SQLException ex) {
            throw new DataAccessException(ex.getMessage());
        }finally {
            database.endTransaction();
        }
    }

    public void save(List<Interesse> interesses) {

        SQLiteDatabase database = sqlHelper.getWritableDatabase();

        try {
            database.beginTransaction();
            for(Interesse interesse : interesses) {
                database.execSQL(
                        " INSERT INTO `Interesse` (`id`, id_interessado, data_interesse, data_aprovacao)" +
                                " VALUES ('" + interesse.getId() +
                                "', '" + interesse.getInteressado().getId() +
                                "', '" + DateFormatUtils.dateToString(interesse.getDataInteresse()) +
                                "', '" + DateFormatUtils.dateToString(interesse.getDataAprovacao()) + "');");
            }
            database.setTransactionSuccessful();
        } catch (SQLException ex) {
            throw new DataAccessException(ex.getMessage());
        }finally {
            database.endTransaction();
        }
    }

    public void delete(Interesse interesse) {

        SQLiteDatabase database = sqlHelper.getWritableDatabase();

        try {
            database.beginTransaction();
            database.execSQL(
                    " INSERT INTO `Interesse` (`id`, id_interessado, data_interesse, data_aprovacao)" +
                            " VALUES ('" + interesse.getId() +
                            "', '" + interesse.getInteressado().getId() +
                            "', '" + DateFormatUtils.dateToString(interesse.getDataInteresse()) +
                            "', '" + DateFormatUtils.dateToString(interesse.getDataAprovacao()) + "');");
            database.setTransactionSuccessful();
        } catch (SQLException ex) {
            throw new DataAccessException(ex.getMessage());
        }finally {
            database.endTransaction();
        }
    }

    public List<Interesse> getAllInteresses() {

        SQLiteDatabase database = sqlHelper.getReadableDatabase();
        Cursor rs = database.rawQuery(
                "SELECT id, id_interessado, data_interesse, id_anuncio, data_aprovacao " +
                        "FROM Interesse ", null);

        List<Interesse> interesses = new ArrayList<Interesse>();

        while(rs.moveToNext()){
            Interesse inter = new Interesse();
            inter.setId(rs.getLong(0));
            inter.setInteressado(new Usuario(rs.getLong(1)));
            inter.setDataInteresse(DateFormatUtils.stringToDate(rs.getString(2)));
            inter.setAnuncio(new Anuncio(rs.getLong(0)));
            inter.setDataAprovacao(DateFormatUtils.stringToDate(rs.getString(3)));
            interesses.add(inter);
        }
        rs.close();
        return interesses;
    }
}
