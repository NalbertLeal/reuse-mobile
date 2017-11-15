package br.ufrn.reuse.repository.local.config;

import android.content.res.Resources;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by danielsmith on 07/11/2017.
 *
 * @author Daniel Smith
 * @author Nalbert Gabriel
 */

public class Migracao implements Comparable {
    /**
     * Nome completo do arquivo;
     */
    private String nomeArquivo;

    /**
     * Versão do arquivo
     */
    private int versao;

    private int resourceId;

    /**
     *
     */
    private String nomeResource;

    private String sql;

    /**
     * Logger da classe
     */
    private Logger logger = Logger.getLogger(this.getClass().toString());

    public Migracao(String nomeArquivo, int versao, int resourceId, String nomeResource, String sql) {
        this.nomeArquivo = nomeArquivo;
        this.versao = versao;
        this.resourceId = resourceId;
        this.nomeResource = nomeResource;
        this.sql = sql;
    }

    public String getSqlMigracao() throws IOException {
        return sql;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public int getVersao() {
        return versao;
    }

    public void setVersao(int versao) {
        this.versao = versao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Migracao migracao = (Migracao) o;

        return versao == migracao.versao;

    }

    @Override
    public int hashCode() {
        return versao;
    }


    @Override
    public int compareTo(@NonNull Object o) {
        return Integer.compare(this.getVersao(), ((Migracao) o).getVersao());
    }
}
