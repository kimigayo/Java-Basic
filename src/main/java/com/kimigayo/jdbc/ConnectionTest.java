package com.kimigayo.jdbc;

import com.kimigayo.basics.io.FileUtil;

import java.io.IOException;
import java.sql.*;

public class ConnectionTest {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement statement1 = null;
        ResultSet set = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud", "root", "123456");
            System.out.println(connection);
//            statement = connection.createStatement();//存在SQL注入风险
//            String sql = "INSERT INTO customer(first_name,last_name) VALUES ('张三','王五')";
//            System.out.println(statement.execute(sql));

//            String sql = "insert into customer(first_name,last_name) values(?,?)";
//            statement1 = connection.prepareStatement(sql);
//            statement1.setObject(1,"伍子胥");
//            statement1.setObject(2,"申包胥");
//            statement1.execute();

            String sql = "SELECT id,first_name,last_name from customer";
            statement1 = connection.prepareStatement(sql);
            set = statement1.executeQuery();
            while (set.next()){
                System.out.println(set.getInt(1)+"-----"+set.getString(2)+"-----"+set.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (null != set) {
                try {
                    set.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != statement) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != statement1) {
                try {
                    statement1.close();
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
