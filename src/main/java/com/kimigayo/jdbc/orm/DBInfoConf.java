package com.kimigayo.jdbc.orm;

import java.io.IOException;
import java.util.Properties;

public class DBInfoConf {
    public static final String DRIVER;
    public static final  String URL;
    public static final  String USER;
    public static final  String PASSWORD;
    public static final  int MIN_CONN_NUMBER;
    public static final  int MAX_CONN_NUMBER;
    static {
        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DRIVER = properties.getProperty("driver");
        URL = properties.getProperty("url");
        USER = properties.getProperty("user");
        PASSWORD = properties.getProperty("pwd");
        MIN_CONN_NUMBER = (int) properties.getOrDefault("min_conn_number",50);
        MAX_CONN_NUMBER = (int) properties.getOrDefault("max_conn_number",100);
    }
}
