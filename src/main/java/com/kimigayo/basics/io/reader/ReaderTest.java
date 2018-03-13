package com.kimigayo.basics.io.reader;

import java.io.*;

/**
 * Reader仅支持文本
 */
public class ReaderTest {
    public static void main(String[] args) {
        Reader reader=null;
        try {
            reader =new BufferedReader(new FileReader("./db.properties"));
            char[] chars = new char[1024];
            int len;
            StringBuffer buffer = new StringBuffer("");
            while ((len = reader.read(chars))>0){
                buffer.append(chars,0,len);
            }
            System.out.println(buffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=reader){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
