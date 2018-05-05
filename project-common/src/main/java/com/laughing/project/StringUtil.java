package com.laughing.project;


public class StringUtil {
    
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
