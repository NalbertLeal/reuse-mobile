package br.ufrn.reuse.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Pega o retorno de uma URL com string.
 *
 * @author Nalbert Gabriel Melo Leal, Daniel Smith
 *
 */
public class HttpUtils {

    public static InputStream recoverInputStream(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        int status = connection.getResponseCode();
        if(status != 200) {
            return null;
        }
        //connection.setDoInput(true);
        //connection.connect();
        return connection.getInputStream();
    }

}
