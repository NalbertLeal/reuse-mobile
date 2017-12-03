package br.ufrn.reuse.repository.anuncio.local;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;
import br.ufrn.reuse.dominio.anuncio.StatusAnuncio;
import br.ufrn.reuse.dominio.comum.Unidade;
import br.ufrn.reuse.dominio.patrimonio.Bem;
import br.ufrn.reuse.repository.local.config.DataAccessException;
import br.ufrn.reuse.utils.DateFormatUtils;

/**
 * Created by nalbertg on 26/10/17.
 */
public class AnuncioLocalRepository extends LocalRepository{

    public AnuncioLocalRepository(Context context) {
        super(context);
    }

    public Anuncio findById(Long idAnuncio){
        SQLiteDatabase database = sqlHelper.getReadableDatabase();
        Cursor rs = database.rawQuery(
            "SELECT id, texto_publicacao, st.id, st.nome, data_cadastro, data_publicacao," +
                    "bem.id, bem.denominacao, bem.numTombamento, uni.id, uni.codigo, uni.nome, uni.sigla, " +
                    "quantidade_dias_ativo, data_sincronizacao, cat.identificador, cat.descricao " +
                "LEFT JOIN status_anuncio st, id_bem bem, categoria_anuncio cat, id_unidade uni" +
                "FROM anuncio" +
                "WHERE anuncio.id = " + idAnuncio, null);

        Anuncio anuncio = new Anuncio();

        while(rs.moveToNext()){
            anuncio.setId(rs.getLong(0));
            anuncio.setTextoPublicacao(rs.getString(1));
            anuncio.setStatusAnuncio(new StatusAnuncio(rs.getString(2), rs.getString(3)));
            anuncio.setDataCadastro(DateFormatUtils.stringToDate(rs.getString(4)));
            anuncio.setDataPublicacao(DateFormatUtils.stringToDate(rs.getString(5)));
            anuncio.setBem(new Bem(rs.getLong(6), rs.getString(7), rs.getInt(8)));
            anuncio.setUnidade(new Unidade(rs.getLong(9), rs.getLong(10), rs.getString(11), rs.getString(12)));
            anuncio.setQuantidadeDiasAtivo(rs.getInt(13));
            anuncio.setDataSincronizacao(DateFormatUtils.stringToDate(rs.getString(14)));
            anuncio.setCategoria(new CategoriaAnuncio(rs.getString(15), rs.getString(16)));
        }
        rs.close();
        return anuncio;
    }

    public void save(Anuncio anuncio) {

        SQLiteDatabase database = sqlHelper.getWritableDatabase();

        try {
            database.beginTransaction();
            database.execSQL(
                    " INSERT INTO `anuncio` (`id`, texto_publicacao, status_anuncio, data_cadastro, data_publicacao," +
                            "id_bem, id_unidade, quantidade_dias_ativo, categoria_anuncio, data_sincronizacao)" +
                            " VALUES ('" + anuncio.getId() +
                            "', '" + anuncio.getTextoPublicacao() +
                            "', '" + anuncio.getStatusAnuncio().getIdentificador() +
                            "', '" + DateFormatUtils.dateToString(anuncio.getDataCadastro()) +
                            "', '" + DateFormatUtils.dateToString(anuncio.getDataPublicacao()) +
                            "', '" + anuncio.getBem().getId() +
                            "', '" + anuncio.getUnidade().getId() +
                            "', '" + anuncio.getQuantidadeDiasAtivo() +
                            "', '" + anuncio.getCategoria().getIdentificador() +
                            "', '" + DateFormatUtils.dateToString(anuncio.getDataSincronizacao()) + "');");
            database.setTransactionSuccessful();
        } catch (SQLException ex) {
            throw new DataAccessException(ex.getMessage());
        }finally {
            database.endTransaction();
        }
    }
}
