package com.kimigayo.jdbc.orm.connection;

import com.kimigayo.jdbc.orm.DBInfoConf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnIml implements DBConn{
    private final static DBConn dbconn = new DBconnIml();
    private DBconnIml(){};
    public static DBConn getDbconn(){
        return dbconn;
    }
    public Connection createConn() {
        try {
            Class.forName(DBInfoConf.DRIVER);
            return DriverManager.getConnection(DBInfoConf.URL,DBInfoConf.USER,DBInfoConf.PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeConn(Connection connection) {
        if (null!=connection){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
