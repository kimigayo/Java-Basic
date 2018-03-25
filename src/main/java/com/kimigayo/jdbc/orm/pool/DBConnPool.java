package com.kimigayo.jdbc.orm.pool;

import com.kimigayo.jdbc.orm.DBInfoConf;
import com.kimigayo.jdbc.orm.connection.DBconnIml;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingQueue;

public class DBConnPool {
    private LinkedBlockingQueue<Connection> conns = new LinkedBlockingQueue<>();
    private final static DBConnPool pool = new DBConnPool();
    private DBConnPool(){}
    static {
        for (int i=0;i< DBInfoConf.MIN_CONN_NUMBER;i++){
            DBConnPool.getPool().conns.offer(DBconnIml.getDbconn().createConn());
        }
    }
    private static DBConnPool getPool(){
        return pool;
    }
    public static Connection getConnection(){
        if (DBInfoConf.MIN_CONN_NUMBER>pool.conns.size()){
            synchronized (pool.conns) {
                if (DBInfoConf.MIN_CONN_NUMBER>pool.conns.size()) {
                    pool.conns.offer(DBconnIml.getDbconn().createConn());
                }
            }
        }
        return pool.conns.poll();
    }
    public static synchronized void closeConnection(Connection connection){
        System.out.println(Thread.currentThread()+"数据库链接数："+pool.conns.size());
        if(DBInfoConf.MAX_CONN_NUMBER>pool.conns.size()){
            pool.conns.offer(connection);
        }else {
            try {
                if(null!=connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
