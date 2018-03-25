package com.kimigayo.jdbc.orm.query;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface QueryCallback {
    void callback(ResultSet set) throws SQLException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;
}
