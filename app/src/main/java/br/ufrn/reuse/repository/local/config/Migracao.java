package br.ufrn.reuse.repository.local.config;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by danielsmith on 07/11/2017.
 * @author Daniel Smith
 * @author Nalbert Gabriel
 */

public class Migracao {
    /**
     * Nome completo do arquivo;
     */
    private String nomeArquivo;

    /**
     * Versão do arquivo
     */
    private int versao;

    /**
     * Logger da classe
     * */
    private Logger logger = Logger.getLogger( this.getClass().toString() );

    public Migracao(String nomeArquivo, int versao) {
        this.nomeArquivo = nomeArquivo;
        this.versao = versao;
    }

    /**
     * Aplica a migração na base de dados
     *
     * @param database
     */
    public void aplicar(SQLiteDatabase database) {
        try {
            database.beginTransaction();
            database.execSQL(getSqlMigracao());
            database.setTransactionSuccessful();
        }catch (SQLException exception){
            throw new DataAcessException("Erro ao efetuar migração da base de dados para a versão "+this.versao);
        }catch (IOException ex){
            throw new DataAcessException("Erro ao recuperar os dados do arquivo de migração.");
        }finally {
            database.endTransaction();
        }
    }

    private String getSqlMigracao() throws IOException {

        //TODO: Recuperar o sql de migração e retornar no final do escopo
        //OBS: Lembrar de fechar o inputstream do arquivo ou utilize try with resources como está abaixo
        //OBS: Lembrar de apagar os comentários =)))

        /* try(InputStream inputStream = System.in) {


        }*/
        try {
            FileInputStream fileStream = new FileInputStream(this.nomeArquivo);

            int line;
            String content = "";
            while((line = fileStream.read()) != -1) {
                content += (char) line;
            }

            fileStream.close();

            return content;
        }
        catch(IOException e) {
            this.logger.log(Level.SEVERE, "Não foi possivel ler arquivo " + this.nomeArquivo);
        }

        return null;
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



}
