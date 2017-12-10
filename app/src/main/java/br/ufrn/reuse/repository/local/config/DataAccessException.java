package br.ufrn.reuse.repository.local.config;

import java.io.IOException;

/**
 * Created by Daniel on 11/7/2017.
 */

public class DataAccessException extends RuntimeException {
    public DataAccessException(String s) {
        super(s);
    }

    public DataAccessException(String s, IOException e) {
        super(s,e);
    }
}
