package com.kimigayo.excel;

public class ExcelField {
    private String id;
    private String exField;
    private String tabField;
    private int column;
    private boolean nullAble;

    public boolean isNullAble() {
        return nullAble;
    }

    public void setNullAble(boolean nullAble) {
        this.nullAble = nullAble;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExField() {
        return exField;
    }

    public void setExField(String exField) {
        this.exField = exField;
    }

    public String getTabField() {
        return tabField;
    }

    public void setTabField(String tabField) {
        this.tabField = tabField;
    }
}
