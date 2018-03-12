package com.kimigayo.basics.file;

import java.io.*;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties properties  = new Properties();
        properties.setProperty("driver","oracle.jdbc.driver.OracleDriver");
        properties.setProperty("url","jdbc:oracle.thin:@localhost:1521:orcl");
        properties.setProperty("user","admin");
        properties.setProperty("pwd","1");
        //项目相对路径
//        properties.store(new FileOutputStream(new File("src/main/java/com//db.properties")),"db配置");
        //
        properties.store(new FileOutputStream(new File("src/main/resource/db.properties")),"db配置");
        //绝对路径
//        properties.store(new FileOutputStream(new File("e:/db/db.properties")),"db配置");
//        properties.storeToXML(new FileOutputStream(new File("src/main/resource/db.xml")),"db配置");
//        相对路径
//        properties.load(new FileReader("src/db.properties"));
//        //类相对路径
//        properties.load(PropertiesTest.class.getResourceAsStream("/db.properties"));
        //类加载器相对路径
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        System.out.println(properties.getProperty("driver","mysql"));
    }
}
