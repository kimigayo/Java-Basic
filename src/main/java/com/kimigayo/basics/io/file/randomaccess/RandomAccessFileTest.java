package com.kimigayo.basics.io.file.randomaccess;

import com.kimigayo.basics.io.FileUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) {
//        RandomAccessFile file = null;
//        try {
//            file = new RandomAccessFile("./db.properties", "rw");
//            file.seek(30);
//            byte[] bytes = new byte[1024];
//            int len;
//            while((len=file.read(bytes))>0){
//                System.out.println(new String(bytes));
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            FileUtil.closeAll(file);
//        }
        RandomAccessFileUtil fileUtil = new RandomAccessFileUtil(50,"./db.properties");
        fileUtil.fileCut();

    }
}