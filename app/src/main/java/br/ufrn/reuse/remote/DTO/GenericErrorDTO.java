package br.ufrn.reuse.remote.DTO;

/**
 * Created by Daniel on 11/18/2017.
 */

public class GenericErrorDTO {
    //"httpCode": 401,
    private int statusCode;
    private String message;
    private String description;

    public GenericErrorDTO(){}

    public boolean isAnTokenExpiredError(){
        return message == "Erro de Token expirado.";
    }

}
