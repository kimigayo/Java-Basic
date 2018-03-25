package com.kimigayo.jdbc.orm.util;

public class DBInfoUtil {
    public static String column2attr(String column){
        String[] cols = column.split("_");
        StringBuffer buffer = new StringBuffer();
        for(int i=0;i<cols.length;i++){
            buffer.append(cols[i].substring(0,1).toUpperCase()+cols[i].substring(1));
        }
        return buffer.toString();
    }
}
