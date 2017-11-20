package br.ufrn.reuse.utils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Daniel on 11/18/2017.
 */

public class IOUtils {

    public static String toString(InputStream fileStream) throws IOException {
        String content = "";
        int line;
        while((line = fileStream.read()) != -1) {
            content += (char) line;
        }

        return content;
    }

}
