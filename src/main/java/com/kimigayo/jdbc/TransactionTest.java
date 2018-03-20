package com.kimigayo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 事务的四大特性：原子性、一致性、隔离性（读取未提交，读取已提交，可重复读，序列化）、持久性
 */
public class TransactionTest {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud", "root", "123456");

            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.execute("INSERT INTO customer(first_name,last_name) VALUES ('张三','王五')");
            Thread.sleep(1000);
//            statement.execute("INSERT INTO customer(id,first_name,last_name) VALUES ('张三','王五')");
            connection.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
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
