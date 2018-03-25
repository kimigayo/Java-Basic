package com.kimigayo.jdbc.orm.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectUtil {
    public static void invokeSet(Object o,String columnName,Object columnValue) {
        Method method = null;
        try {
            method = o.getClass().getDeclaredMethod("set" + DBInfoUtil.column2attr(columnName), columnValue.getClass());
            method.invoke(o, columnValue);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
