package com.kimigayo.basics.io.file;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class FileTest {
    public static void main(String[] args) {
//        System.out.println(File.pathSeparator);//路径分隔符
//        System.out.println(File.separator);//文件分隔符，windows\与linux不同/
//        File file = new File("E:/db/","/basic.txt");//推荐使用/
//        System.out.println(file.getAbsolutePath());
//        file.mkdir();//若其中包含不存在的路径，则不创建
//        file.mkdirs();//不存在的目录也进行创建
        File file = new File("E:/安装包");
        File[] file1 = file.listFiles(new FilenameFilter() {//命令模式
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".zip");
            }
        });
        for (File file2 :file1)
            System.out.println(file2.getName());
        //        readFile("E:\\安装包", 1);
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
