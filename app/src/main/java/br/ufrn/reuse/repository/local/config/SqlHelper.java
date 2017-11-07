package br.ufrn.reuse.repository.local.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

import br.ufrn.reuse.R;
import br.ufrn.reuse.utils.ReflectionUtils;

/**
 * Created by Daniel on 10/25/2017.
 */
public class SqlHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "reuse";

    private Context context;

    public SqlHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        migrateToLatestVersion(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {

    }

    private void migrateToLatestVersion(SQLiteDatabase database) {
        migrateToLatestVersion(database, 0);
    }

    private void migrateToLatestVersion(SQLiteDatabase database, int oldVersion) {
        Class<R.raw> classe = R.raw.class;
        List<Field> fields = ReflectionUtils.getAllStaticField(classe);

        for (Field field : fields) {
            try {
                Integer idResource = field.getInt(null);
                String name = field.getName();
                String[] split = name.split("_");
                String versao = split[0];
                int numVersao = Integer.parseInt(versao);

                String extensaoArquivo = null;
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }




        Migracao migracao = new Migracao("", 1);

    }

    static String sql = "BEGIN TRANSACTION;\n" +
            "CREATE TABLE IF NOT EXISTS `unidade` (\n" +
            "\t`id`\tINTEGER UNIQUE,\n" +
            "\t`codigo`\tINTEGER,\n" +
            "\t`nome`\tTEXT,\n" +
            "\t`sigla`\tTEXT,\n" +
            "\tPRIMARY KEY(`id`)\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS `status_anuncio` (\n" +
            "\t`id`\tTEXT UNIQUE,\n" +
            "\t`nome`\tTEXT,\n" +
            "\tPRIMARY KEY(`id`)\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS `historico_anuncio` (\n" +
            "\t`id`\tINTEGER,\n" +
            "\t`id_anuncio`\tINTEGER,\n" +
            "\t`status_anuncio`\tTEXT,\n" +
            "\t`data_alteracao`\tTEXT,\n" +
            "\t`id_usuario`\tINTEGER,\n" +
            "\t`justificativa`\tTEXT,\n" +
            "\tPRIMARY KEY(`id`)\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS `foto` (\n" +
            "\t`id`\tINTEGER UNIQUE,\n" +
            "\t`id_arquivo`\tINTEGER UNIQUE,\n" +
            "\t`url_foto`\tTEXT,\n" +
            "\t`id_anuncio`\tINTEGER,\n" +
            "\tPRIMARY KEY(`id`)\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS `etiqueta` (\n" +
            "\t`id`\tINTEGER UNIQUE,\n" +
            "\t`nome`\tTEXT,\n" +
            "\tPRIMARY KEY(`id`)\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS `categoria_anuncio` (\n" +
            "\t`id`\tTEXT UNIQUE,\n" +
            "\t`descricao`\tTEXT,\n" +
            "\tPRIMARY KEY(`id`)\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS `anuncio` (\n" +
            "\t`texto_publciacao`\tTEXT,\n" +
            "\t`id`\tINTEGER,\n" +
            "\t`status_anuncio`\tINTEGER,\n" +
            "\t`data_cadastro`\tTEXT,\n" +
            "\t`data_publicacao`\tINTEGER,\n" +
            "\t`id_bem`\tINTEGER,\n" +
            "\t`id_unidade`\tINTEGER,\n" +
            "\t`categoria_anuncio`\tINTEGER,\n" +
            "\t`quantidade_dias_ativo`\tINTEGER,\n" +
            "\t`data_sincronizacao`\tTEXT\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS `Usuario` (\n" +
            "\t`id`\tINTEGER,\n" +
            "\t`login`\tTEXT,\n" +
            "\t`id_unidade`\tINTEGER,\n" +
            "\t`email`\tTEXT,\n" +
            "\t`url_foto`\tTEXT\n" +
            ");\n" +
            "CREATE TABLE IF NOT EXISTS `Interesse` (\n" +
            "\t`id`\tINTEGER UNIQUE,\n" +
            "\t`id_interessado`\tINTEGER UNIQUE,\n" +
            "\t`data_interesse`\tTEXT,\n" +
            "\t`id_anuncio`\tINTEGER,\n" +
            "\t`data_aprovacao`\tTEXT,\n" +
            "\tPRIMARY KEY(`id`)\n" +
            ");\n" +
            "COMMIT;\n";

}
