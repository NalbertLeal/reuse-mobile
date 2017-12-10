package br.ufrn.reuse.utils.json;

import com.google.gson.Gson;

/**
 * Created by Daniel on 11/18/2017.
 */

public class JsonParser {

    public static <T> T fromJson(String jsonObject, Class<T> dtoType){
        Gson gson = new Gson();
        return gson.fromJson(jsonObject, dtoType);
    }

    public static String toJson(Object object){
        Gson gson = new Gson();
        return gson.toJson(object);
    }

}
