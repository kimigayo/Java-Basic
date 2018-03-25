package com.kimigayo.jdbc.orm.query;

public class MysqlQuery extends AbstractQuery{
    private final static MysqlQuery QUERY = new MysqlQuery();

    private MysqlQuery() {
    }
    public static Query getInstance(){
        return QUERY;
    }
}
