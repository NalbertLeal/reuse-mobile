package br.ufrn.reuse.repository.patrimonio.local;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import br.ufrn.reuse.dominio.patrimonio.Bem;
import br.ufrn.reuse.repository.anuncio.local.LocalRepository;
import br.ufrn.reuse.repository.local.config.DataAccessException;
import br.ufrn.reuse.utils.DateFormatUtils;

import android.database.Cursor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Esther on 03/12/2017.
 */

public class BemLocalRepository extends LocalRepository {

    public BemLocalRepository(Context context) {
        super(context);
    }

    public Bem findBemById(Long idBem) {
        SQLiteDatabase database = sqlHelper.getReadableDatabase();
        Cursor rs = database.rawQuery(
                " SELECT id, denominacao, numTombamento, observacoes, dataSincronizacao " +
                        " FROM bem" +
                        " WHERE bem.id = " + idBem, null);

        Bem bem = null;

        while(rs.moveToNext()){
            bem = new Bem(rs.getLong(0), rs.getString(1), rs.getInt(2));
            bem.setObservacoes(rs.getString(3));
            bem.setDataSincronizacao(DateFormatUtils.stringToDate(rs.getString(4)));
        }
        rs.close();
        return bem;
    }

    public void save(Bem bem) {

        SQLiteDatabase database = sqlHelper.getWritableDatabase();

        try {
            database.beginTransaction();
            database.execSQL(
                    " INSERT INTO `bem` (`id`, `denominacao`, 'numTombamento')" +
                    " VALUES ('" + bem.getId() +
                            "', '" + bem.getDenominacao() +
                            "', '" + bem.getNumTombamento() +
                            "', '" + bem.getObservacoes() +
                            "', '" + bem.getDataSincronizacao() + "');");
            database.setTransactionSuccessful();
        } catch (SQLException ex) {
            throw new DataAccessException(ex.getMessage());
        }finally {
            database.endTransaction();
        }
    }

    public List<Bem> findAllBens() throws ParseException {
        SQLiteDatabase database = sqlHelper.getReadableDatabase();
        Cursor rs = database.rawQuery(
                " SELECT id, denominacao, numTombamento, observacoes, dataSincronizacao " +
                        " FROM bem", null);

        List<Bem> bens = new ArrayList<Bem>();

        while(rs.moveToNext()){
            Bem bem = new Bem(rs.getLong(0), rs.getString(1), rs.getInt(2));
            bem.setObservacoes(rs.getString(3));
            bem.setDataSincronizacao(new SimpleDateFormat().parse(rs.getString(4)));
            bens.add(bem);
        }
        rs.close();
        return bens;
    }
}
