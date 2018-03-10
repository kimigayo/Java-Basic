package com.kimigayo.basics.file;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        readFile("E:\\安装包", 1);
    }

    public static void readFile(String pathName, int level) {
        File file = new File(pathName);
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(file.getName());
        File[] sonFiles = file.listFiles();
        level = level+1;
        if (null != sonFiles)
            for (File filel : sonFiles) {
                readFile(filel.getAbsolutePath(), level);
            }
    }
}
