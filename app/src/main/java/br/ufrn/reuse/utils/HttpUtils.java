package br.ufrn.reuse.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Pega o retorno de uma URL com string.
 * @author Nalbert Gabriel Melo Leal
 * @Deniel Smith
 */
public class HttpUtils {

    public static InputStream recoverInputStream(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.connect();
        return connection.getInputStream();
    }

}
