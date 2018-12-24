package com.kimigayo.basics.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(readFile());
        System.out.println(getException());
    }

    public static String getException() throws FileNotFoundException {
        try {
            throw new NullPointerException();
        }finally {
//            return "";
            throw new FileNotFoundException();
        }
    }
    public static String readFile() {
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(new File("D://d.txt"));
            return "111";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "222";
        } catch (IOException e) {
            e.printStackTrace();
            return "333";
        } finally {
            try {
                if (null != stream)
                    stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "fff";//最后执行，覆盖前面的return
        }
    }
}
