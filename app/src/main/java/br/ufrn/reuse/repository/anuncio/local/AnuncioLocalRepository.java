package br.ufrn.reuse.repository.anuncio.local;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.reuse.dominio.anuncio.Anuncio;
import br.ufrn.reuse.dominio.anuncio.CategoriaAnuncio;
import br.ufrn.reuse.dominio.anuncio.StatusAnuncio;
import br.ufrn.reuse.dominio.comum.Unidade;
import br.ufrn.reuse.dominio.patrimonio.Bem;
import br.ufrn.reuse.repository.local.config.DataAccessException;
import br.ufrn.reuse.utils.DateFormatUtils;

/**
 * Created by nalbertg on 26/10/17.
 * @author Esther
 */
public class AnuncioLocalRepository extends LocalRepository{

    public AnuncioLocalRepository(Context context) {
        super(context);
    }

    public Anuncio findById(Long idAnuncio){
        SQLiteDatabase database = sqlHelper.getReadableDatabase();
        Cursor rs = database.rawQuery(
                "SELECT id, texto_publicacao, data_cadastro, data_publicacao, quantidade_dias_ativo, data_sincronizacao, " +
                        "id_bem, status_anuncio, id_unidade, categoria_anuncio " +
                    "FROM anuncio " +
                    "WHERE anuncio.id = " + idAnuncio, null);

        Anuncio anuncio = new Anuncio();

        while(rs.moveToNext()){
            anuncio.setId(rs.getLong(0));
            anuncio.setTextoPublicacao(rs.getString(1));
            anuncio.setDataCadastro(DateFormatUtils.stringToDate(rs.getString(2)));
            anuncio.setDataPublicacao(DateFormatUtils.stringToDate(rs.getString(3)));
            anuncio.setQuantidadeDiasAtivo(rs.getInt(4));
            anuncio.setDataSincronizacao(DateFormatUtils.stringToDate(rs.getString(5)));
            anuncio.setBem(new Bem(rs.getLong(6)));
            anuncio.setStatusAnuncio(new StatusAnuncio(rs.getString(7)));
            anuncio.setUnidade(new Unidade(rs.getLong(8)));
            anuncio.setCategoria(new CategoriaAnuncio(rs.getString(9)));
        }
        rs.close();
        return anuncio;
    }

    public List<Anuncio> findAllAnunciosPublicadosTexto(String textoBusca) {
        List<Anuncio> anuncios = new ArrayList<Anuncio>();

        SQLiteDatabase database = sqlHelper.getReadableDatabase();
        Cursor rs = database.rawQuery(
                "SELECT id, texto_publicacao, data_cadastro, data_publicacao, quantidade_dias_ativo, data_sincronizacao, " +
                        "id_bem, status_anuncio, id_unidade, categoria_anuncio " +
                    "FROM anuncio " +
                    "WHERE texto_publicacao == '" + textoBusca + "'", null);

        while(rs.moveToNext()){
            Anuncio anuncio = new Anuncio();
            anuncio.setId(rs.getLong(0));
            anuncio.setTextoPublicacao(rs.getString(1));
            anuncio.setDataCadastro(DateFormatUtils.stringToDate(rs.getString(2)));
            anuncio.setDataPublicacao(DateFormatUtils.stringToDate(rs.getString(3)));
            anuncio.setQuantidadeDiasAtivo(rs.getInt(4));
            anuncio.setDataSincronizacao(DateFormatUtils.stringToDate(rs.getString(5)));
            anuncio.setBem(new Bem(rs.getLong(6)));
            anuncio.setStatusAnuncio(new StatusAnuncio(rs.getString(7)));
            anuncio.setUnidade(new Unidade(rs.getLong(8)));
            anuncio.setCategoria(new CategoriaAnuncio(rs.getString(9)));
            anuncios.add(anuncio);
        }
        rs.close();
        return anuncios;
    }

    public List<Anuncio> findAllAnunciosPublicadosCategoria(List<CategoriaAnuncio> categorias) {
        List<Anuncio> anuncios = new ArrayList<Anuncio>();

        SQLiteDatabase database = sqlHelper.getReadableDatabase();
        String whereSql = "WHERE ";
        int index = 0;
        for(CategoriaAnuncio cat : categorias){
            if(index != 0) {
                whereSql += " || ";
            }
            index++;
            whereSql += "categoria_anuncio == '" + cat.getIdentificador() + "'";
        }
        Cursor rs = database.rawQuery(
                "SELECT id, texto_publicacao, data_cadastro, data_publicacao, quantidade_dias_ativo, data_sincronizacao, " +
                        "id_bem, status_anuncio, id_unidade, categoria_anuncio " +
                    "FROM anuncio " +
                    whereSql, null);

        while(rs.moveToNext()){
            Anuncio anuncio = new Anuncio();
            anuncio.setId(rs.getLong(0));
            anuncio.setTextoPublicacao(rs.getString(1));
            anuncio.setDataCadastro(DateFormatUtils.stringToDate(rs.getString(2)));
            anuncio.setDataPublicacao(DateFormatUtils.stringToDate(rs.getString(3)));
            anuncio.setQuantidadeDiasAtivo(rs.getInt(4));
            anuncio.setDataSincronizacao(DateFormatUtils.stringToDate(rs.getString(5)));
            anuncio.setBem(new Bem(rs.getLong(6)));
            anuncio.setStatusAnuncio(new StatusAnuncio(rs.getString(7)));
            anuncio.setUnidade(new Unidade(rs.getLong(8)));
            anuncio.setCategoria(new CategoriaAnuncio(rs.getString(9)));
            anuncios.add(anuncio);
        }
        rs.close();
        return anuncios;
    }

    public void save(Anuncio anuncio) {

        SQLiteDatabase database = sqlHelper.getWritableDatabase();

        try {
            database.beginTransaction();
            Long idbem = anuncio.getBem()!=null && anuncio.getBem().getId()!=null ? anuncio.getBem().getId() : null;
            Long idunidade = anuncio.getUnidade()!=null && anuncio.getUnidade().getId()!=null ? anuncio.getUnidade().getId() : null;
            String idstatus = anuncio.getStatusAnuncio()!=null && anuncio.getStatusAnuncio().getIdentificador()!=null ? anuncio.getStatusAnuncio().getIdentificador() : null;
            String idcategoria = anuncio.getCategoria()!=null && anuncio.getCategoria().getIdentificador()!=null ? anuncio.getCategoria().getIdentificador() : null;
            database.execSQL(
                    " INSERT INTO `anuncio` (id, texto_publicacao, data_cadastro, data_publicacao, quantidade_dias_ativo, data_sincronizacao," +
                            " id_bem, id_unidade, categoria_anuncio, status_anuncio)" +
                            " VALUES ('" + anuncio.getId() +
                            "', '" + anuncio.getTextoPublicacao() +
                            "', '" + DateFormatUtils.dateToString(anuncio.getDataCadastro()) +
                            "', '" + DateFormatUtils.dateToString(anuncio.getDataPublicacao()) +
                            "', '" + anuncio.getQuantidadeDiasAtivo() +
                            "', '" + DateFormatUtils.dateToString(DateFormatUtils.dataAtual()) +
                            "', '" + idbem +
                            "', '" + idunidade +
                            "', '" + idcategoria +
                            "', '" + idstatus + "');");
            database.setTransactionSuccessful();
        } catch (SQLException ex) {
            throw new DataAccessException(ex.getMessage());
        }finally {
            database.endTransaction();
        }
    }

    public void save(List<Anuncio> anuncios) {

        SQLiteDatabase database = sqlHelper.getWritableDatabase();

        try {
            database.beginTransaction();
            for(Anuncio anuncio : anuncios) {
                Long idbem = anuncio.getBem()!=null && anuncio.getBem().getId()!=null ? anuncio.getBem().getId() : null;
                Long idunidade = anuncio.getUnidade()!=null && anuncio.getUnidade().getId()!=null ? anuncio.getUnidade().getId() : null;
                String idstatus = anuncio.getStatusAnuncio()!=null && anuncio.getStatusAnuncio().getIdentificador()!=null ? anuncio.getStatusAnuncio().getIdentificador() : null;
                String idcategoria = anuncio.getCategoria()!=null && anuncio.getCategoria().getIdentificador()!=null ? anuncio.getCategoria().getIdentificador() : null;
                database.execSQL(
                        " INSERT INTO `anuncio` (id, texto_publicacao, data_cadastro, data_publicacao, quantidade_dias_ativo, data_sincronizacao," +
                                " id_bem, id_unidade, categoria_anuncio, status_anuncio)" +
                                " VALUES ('" + anuncio.getId() +
                                "', '" + anuncio.getTextoPublicacao() +
                                "', '" + DateFormatUtils.dateToString(anuncio.getDataCadastro()) +
                                "', '" + DateFormatUtils.dateToString(anuncio.getDataPublicacao()) +
                                "', '" + anuncio.getQuantidadeDiasAtivo() +
                                "', '" + DateFormatUtils.dateToString(DateFormatUtils.dataAtual()) +
                                "', '" + idbem +
                                "', '" + idunidade +
                                "', '" + idcategoria +
                                "', '" + idstatus + "');");
            }
            database.setTransactionSuccessful();
        } catch (SQLException ex) {
            throw new DataAccessException(ex.getMessage());
        }finally {
            database.endTransaction();
        }
    }

    public void delete(Anuncio anuncio){
        super.delete("anuncio", anuncio.getId());
    }

    public void delete(List<Anuncio> anuncios){
        for(Anuncio anuncio : anuncios) {
            delete(anuncio);
        }
    }
}
