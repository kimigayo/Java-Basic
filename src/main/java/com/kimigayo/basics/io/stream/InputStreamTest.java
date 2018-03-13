package com.kimigayo.basics.io.stream;

import java.io.*;

public class InputStreamTest {
    public static void main(String[] args) {
        File file = new File("./db.properties");
        InputStream stream = null;
        try {
            stream = new BufferedInputStream(new FileInputStream(file));
//        stream = InputStreamTest.class.getResourceAsStream("/db.properties");
//        stream = InputStreamTest.class.getClassLoader().getResourceAsStream("db.properties");
//        stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
            //

            //byte读取
            byte[] b = new byte[1024];
            int len = 0;
            ByteArrayOutputStream  outputStream = new ByteArrayOutputStream();
            while((len=stream.read(b))>0){
                outputStream.write(b,0,len);
            }
            System.out.println(outputStream.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != stream) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭输入流失败!");
                }
            }
        }
    }
}
