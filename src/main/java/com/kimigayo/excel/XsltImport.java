package com.kimigayo.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XsltImport extends AbstractExcelImport{

    public <T> List<T> loadImportInfo(InputStream stream, List<ExcelField> excelFields, Class<T> aClass) throws IOException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        List temp = new ArrayList();
        //根据指定的文件输入流导入Excel从而产生Workbook对象
        Workbook wb0 = null;
//        if (xlsPath.toUpperCase().endsWith(".xls")) {
//            wb0 = new HSSFWorkbook(stream);
//        } else {
            wb0 = new XSSFWorkbook(stream);
//        }
        //获取Excel文档中的第一个表单
        Sheet sht0 = wb0.getSheetAt(0);
        //对Sheet中的每一行进行迭代
        for (Row r : sht0) {
            //如果当前行的行号（从0开始）未达到2（第三行）则从新循环
            if (r.getRowNum() < 1) {
                continue;
            }
            Object o = newInstance(excelFields, aClass, (column)->getCellValue(r.getCell(column)));
            if (null==o)
                continue;
            temp.add(o);
        }
        stream.close();
        return temp;
    }

    private Object getCellValue(Cell cell){
        switch (cell.getCellTypeEnum()) {
            case STRING:
                return cell.getRichStringCellValue().getString();
            case NUMERIC:
                if("General".equals(cell.getCellStyle().getDataFormatString())){
                    return cell.getNumericCellValue();
                }else if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){
                    return cell.getDateCellValue();
                }else{
                    return cell.getNumericCellValue();
                }
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case BLANK:
                return "";
            default:
                return cell.toString();
        }
    }

//    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
//        List<ExcelField> excelFields = new ArrayList<>();
//        ExcelField excelField1 = new ExcelField();
//        excelField1.setExField("商户编号");
//        excelField1.setTabField("merchantId");
//        excelField1.setColumn(0);
//        excelFields.add(excelField1);
//        ExcelField excelField2 = new ExcelField();
//        excelField2.setExField("创建时间");
//        excelField2.setTabField("createAt");
//        excelField2.setColumn(1);
//        excelFields.add(excelField2);
//        ExcelField excelField3 = new ExcelField();
//        excelField3.setExField("商户交易号");
//        excelField3.setTabField("merchantDealId");
//        excelField3.setColumn(2);
//        excelFields.add(excelField3);
//        List<Bill> objects = new XsltImport().loadImportInfo(Thread.currentThread().getContextClassLoader().getResourceAsStream("./mch_inlet_refund_export_1524185278.48.xlsx"), excelFields, Bill.class);
//        for (Bill b:objects){
//            System.out.println(b);
//        }
//    }
}
