package com.kimigayo.jdbc.orm.util;

import com.kimigayo.jdbc.orm.pool.DBConnPool;
import com.kimigayo.jdbc.orm.query.QueryCallback;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBQueryUtil {
    public static Object executeQueryTemplate(String sql, QueryCallback callback,Object... param) {
        Connection connection = DBConnPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            for (int i=1;null!=param&&i<=param.length;i++){
                statement.setObject(i,param[i-1]);
            }
            ResultSet set = statement.executeQuery();
            callback.callback(set);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            DBConnPool.closeConnection(connection);
        }
        return null;
    }
}
