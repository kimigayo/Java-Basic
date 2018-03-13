package com.kimigayo.basics.io.file;

import java.io.*;

/**
 * 文件复制，包含文件的输入流和输出流应用
 */
public class FileCopyTest {
    public static void main(String[] args) {
        InputStream inputStream = null ;
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("./db2.properties");
            inputStream = new FileInputStream("./db.properties");
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len=inputStream.read(bytes))>0){
                outputStream.write(bytes,0,len);
            }
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭输入流失败");
                }
            }

            if(null!=outputStream){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭输出流失败");
                }
            }
        }
    }

}
