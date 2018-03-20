package com.kimigayo.jdbc;

import java.io.*;
import java.sql.*;

public class ClobTest {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        PreparedStatement statement1 = null;
        ResultSet set = null;
        Reader reader = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud", "root", "123456");
//            String sql = "insert into customer(first_name,last_name,individual_resume) values(?,?,?)";
//            statement1 = connection.prepareStatement(sql);
//            statement1.setObject(1,"伍子胥");
//            statement1.setObject(2,"申包胥");
//            statement1.setClob(3,new BufferedReader(new FileReader("C:\\Users\\chenbinbin\\Desktop\\简介.txt")));
//            statement1.execute();

            String sql = "SELECT id,first_name,last_name,individual_resume from customer";
            statement1 = connection.prepareStatement(sql);
            set = statement1.executeQuery();
            while (set.next()) {
//                System.out.println(set.getInt(1)+"-----"+set.getString(2)+"-----"+set.getString(3));
                Clob clob = set.getClob(4);
                reader = clob.getCharacterStream();
                char[] chars = new char[1024];
                while (reader.read(chars) > 0) {
                    System.out.println(chars);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
