package br.ufrn.reuse.utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by Esther on 03/12/2017.
 */

public class DateFormatUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static String dateToString(Date data){
        String dataString = data.toLocaleString();
        return dataString;
    }

    public static Date stringToDate(String dataString){
        try {
            return sdf.parse(dataString);
        } catch (ParseException e) {
            return null;
        }
    }

}
