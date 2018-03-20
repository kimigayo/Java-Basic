package com.kimigayo.jdbc;

import java.io.*;
import java.sql.*;

public class BolbTest {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement statement1 = null;
        ResultSet set = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud", "root", "123456");
//            String sql = "insert into customer(first_name,last_name,head_portrait) values(?,?,?)";
//            statement1 = connection.prepareStatement(sql);
//            statement1.setObject(1,"伍子胥");
//            statement1.setObject(2,"申包胥");
//            statement1.setBlob(3,new FileInputStream("C:\\Users\\chenbinbin\\Desktop\\2.jpg"));
//            statement1.execute();

            String sql = "SELECT id,first_name,last_name,head_portrait from customer";
            statement1 = connection.prepareStatement(sql);
            set = statement1.executeQuery();
            while (set.next()) {
//                System.out.println(set.getInt(1)+"-----"+set.getString(2)+"-----"+set.getString(3));
                Blob blob = set.getBlob(4);
                inputStream = blob.getBinaryStream();
                outputStream = new FileOutputStream("C:\\Users\\chenbinbin\\Desktop\\3.jpg");
                byte[] bytes = new byte[1024];
                int len;
                while ((len =inputStream.read(bytes))>0) {
                    outputStream.write(bytes,0,len);
                }
                outputStream.flush();
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

            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != outputStream) {
                try {
                    outputStream.close();
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
