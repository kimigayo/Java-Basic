package com.kimigayo.basics.io.reader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterTest {
    public static void main(String[] args) {
        Writer writer =null;
        try {
            writer = new FileWriter("./db2.properties",true);
            writer.write("天作孽尚可违\n自作孽不可活\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=writer){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
