package br.ufrn.reuse.utils.json;

import com.google.gson.Gson;

/**
 * Created by Daniel on 11/18/2017.
 */

public class JsonParser {

    public static <T> T fromJson(String body, Class<T> dtoType){
        Gson gson = new Gson();
        return gson.fromJson(body, dtoType);
    }

}
