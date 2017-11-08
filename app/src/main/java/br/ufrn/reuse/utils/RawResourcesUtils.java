package br.ufrn.reuse.utils;

import android.content.Context;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.reuse.R;

/**
 * Created by Daniel on 11/7/2017.
 */
public class RawResourcesUtils {

    public static List<Integer> getRawResourcesIds(){

        List<Integer> idRawResources = new ArrayList<>();

        for (Field field : ReflectionUtils.getAllStaticFields(R.raw.class)) {
            try {
                idRawResources.add(field.getInt(null));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return idRawResources;
    }

    public static String getResourceName(Context context, int idResource){
        if(context == null){
            throw new IllegalArgumentException("Context não deve ser nulo");
        }

        return context.getResources().getResourceName(idResource);
    }

}
