package br.ufrn.reuse.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.ufrn.reuse.repository.local.config.Migracao;

/**
 * Created by danielsmith on 07/11/2017.
 */
public class ReflectionUtils {
    public static Field[] getAllFields(Class classe){
        return classe.getDeclaredFields();
    }

    public static List<Field> getAllStaticField(Class classe){
        List<Field> staticFields = new ArrayList<>();

        for(Field field : getAllFields(classe)){
            if(Modifier.isStatic(field.getModifiers())){
                staticFields.add(field);
            }

        }

        return staticFields;
    }
}
