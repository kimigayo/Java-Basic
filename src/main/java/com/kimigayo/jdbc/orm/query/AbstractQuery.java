package com.kimigayo.jdbc.orm.query;

import com.kimigayo.jdbc.orm.util.DBInfoUtil;
import com.kimigayo.jdbc.orm.pool.DBConnPool;
import com.kimigayo.jdbc.orm.util.DBQueryUtil;
import com.kimigayo.jdbc.orm.util.ReflectUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractQuery implements Query{
    @Override
    public <T> List<T> executeQuery(String sql,Class<T> tClass, Object... param) {
        final List list = new ArrayList();;
        DBQueryUtil.executeQueryTemplate(sql,new QueryCallback(){
            @Override
            public void callback(ResultSet set) throws SQLException, IllegalAccessException, InstantiationException {
                ResultSetMetaData metaData = set.getMetaData();
                while (set.next()){
                    Object o = tClass.newInstance();
                    for (int i=0;i<metaData.getColumnCount();i++){
                        ReflectUtil.invokeSet(o,metaData.getColumnLabel(i+1), set.getObject(i+1));
                    }
                    list.add(o);
                }
            }
        },param);
        return list;
    }
}
