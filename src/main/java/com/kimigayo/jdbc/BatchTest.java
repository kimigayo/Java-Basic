package com.kimigayo.jdbc;

import java.sql.*;

public class BatchTest {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud", "root", "123456");

            connection.setAutoCommit(false);
            long start = System.currentTimeMillis();
            statement = connection.createStatement();
//            String sql = "INSERT INTO customer(first_name,last_name) VALUES ('张三','王五')";
            for (int i = 0; i < 20000; i++) {
                statement.addBatch("INSERT INTO customer(first_name,last_name) VALUES ('张三" + i + "','王五" + i + "')");
            }
            statement.executeBatch();
            connection.commit();
            System.out.println("总用时：" + (System.currentTimeMillis() - start) + "ms");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != statement) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != connection) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
