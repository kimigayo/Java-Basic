package com.kimigayo.jdbc.orm.connection;

import java.sql.Connection;

public interface DBConn {
    Connection createConn();
    void closeConn(Connection connection);
}
