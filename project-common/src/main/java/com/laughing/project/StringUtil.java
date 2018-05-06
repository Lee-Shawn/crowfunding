package com.laughing.project;

import java.text.SimpleDateFormat;
import java.util.Date;


public class StringUtil {
    
    public static String formatSimpleDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.format(date);
    }
    
    public static boolean isEmpty(String str) {
        if (str == null) {
            return true;
        }

        if (str.trim().equals("")) {
            return true;
        }
        
        return false;
    }

}
