package com.kimigayo.basics.io.system;

import java.io.*;
import java.util.Scanner;

/**
 * system.in
 * system.out
 * system.err
 */
public class SystemTest {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream  inputStream = System.in;
        PrintStream outputStream = System.out;
        PrintStream err = System.err;
        Scanner scanner = new Scanner(inputStream);
        System.out.println("用户输入===》"+scanner.nextLine());
        System.setOut(new PrintStream(new FileOutputStream("./out.txt")));
        System.out.println("输出到文件");
        outputStream.println("系统输出");
        err.println("系统错误");
    }
}
