package com.kimigayo.basics.io.stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamTest {
    public static void main(String[] args) {
        OutputStream stream = null;
        String address = "福建省厦门市软件园二期\n";
        try {
            stream = new FileOutputStream(new File("./ruanjianyan.txt"),true);//true表示追加
            stream.write(address.getBytes());
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=stream) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("输出流关闭失败");
                }
            }
        }
    }
}
