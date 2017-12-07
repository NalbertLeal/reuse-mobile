package br.ufrn.reuse.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Daniel on 12/6/2017.
 */

public class SharedPreferencesUtils {

    public static SharedPreferences getPreferences(String name, Context context){
        return context.getSharedPreferences(name, Activity.MODE_PRIVATE);
    }


}
