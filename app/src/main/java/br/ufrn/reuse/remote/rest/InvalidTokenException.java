package br.ufrn.reuse.remote.rest;

/**
 * Created by Daniel on 11/15/2017.
 */

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException(String s) {
        super(s);
    }
}
