package com.kimigayo.jdbc.orm.query;

import java.util.List;

public interface Query {
    <T> List<T> executeQuery(String sql,Class<T> aClass,Object...param);
}
