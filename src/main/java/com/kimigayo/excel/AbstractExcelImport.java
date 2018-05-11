package com.kimigayo.excel;


import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public abstract class AbstractExcelImport implements IDocuemntImport {
    protected final static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected final static String STRING = "java.lang.String";
    protected final static String Date = "java.util.Date";

    protected Object newInstance(List<ExcelField> excelFields, Class aClass, CellValue cell) {
        Object o = null;
        try {
            o = aClass.newInstance();
            for (ExcelField exfield : excelFields) {
                Field field = aClass.getDeclaredField(exfield.getTabField());
                field.setAccessible(true);
                Object value = getCellValue(cell, field, exfield.getColumn());
                if(!exfield.isNullAble()&&null==value){
                    return null;
                }
                field.set(o, value);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return o;
    }

    protected Object getCellValue(CellValue cell, Field field, int col) {
        switch (field.getType().getName()) {
            case STRING:
                return String.valueOf(cell.formatValue(col));
            case Date:
                try {
                    return format.parse(String.valueOf(cell.formatValue(col)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }

    interface CellValue {
        Object formatValue(int column);
    }
}
