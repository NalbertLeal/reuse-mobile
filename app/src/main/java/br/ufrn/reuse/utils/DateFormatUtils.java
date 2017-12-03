package br.ufrn.reuse.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Esther on 03/12/2017.
 */

public class DateFormatUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat();

    public static String dateToString(Date data){
        String dataString = "";
        data.toString();
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
