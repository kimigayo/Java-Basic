package com.kimigayo.excel;

import com.csvreader.CsvReader;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CsvImport extends AbstractExcelImport {
    public <T> List<T> loadImportInfo(String csvPath, List<ExcelField> excelFields, Class<T> aClass){
        List temp = new ArrayList();
        try {
            ArrayList<String[]> csvList = new ArrayList<String[]>(); //用来保存数据
//注明：或者可以通过前端上传的文件，用一个方法获取上传文件名uploadName(String)
            CsvReader reader = new CsvReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(csvPath),',',Charset.forName("GBK"));    //解决中文编码
            reader.readHeaders(); // 跳过表头   如果需要表头的话，不要写这句。
            while(reader.readRecord()){ //逐行读入除表头的数据
                csvList.add(reader.getValues());
            }
            reader.close();
            for(String[] cells:csvList){
                Object o = newInstance(excelFields, aClass, (column)->cells[column]);
                if (null==o)
                    continue;
                temp.add(o);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return temp;
    }

    public static void main(String[] args) {
        List<ExcelField> excelFields = new ArrayList<>();
        ExcelField excelField1 = new ExcelField();
        excelField1.setExField("交易时间");
        excelField1.setTabField("createAt");
        excelField1.setColumn(0);
        excelFields.add(excelField1);
        ExcelField excelField2 = new ExcelField();
        excelField2.setExField("APPID");
        excelField2.setTabField("merchantId");
        excelField2.setColumn(1);
        excelFields.add(excelField2);
        ExcelField excelField3 = new ExcelField();
        excelField3.setExField("商户号");
        excelField3.setTabField("merchantDealId");
        excelField3.setColumn(2);
        excelFields.add(excelField3);
        List<Bill> objects = new CsvImport().loadImportInfo("100006681810.csv",excelFields, Bill.class);
        for (Bill b:objects){
            System.out.println(b);
        }
    }
}
