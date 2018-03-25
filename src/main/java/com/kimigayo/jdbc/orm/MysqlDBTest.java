package com.kimigayo.jdbc.orm;

import com.kimigayo.jdbc.orm.bean.Customer;
import com.kimigayo.jdbc.orm.pool.DBConnPool;
import com.kimigayo.jdbc.orm.query.MysqlQuery;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class MysqlDBTest {
    public static void main(String[] args) {
        final String sql ="select id,first_name,last_name from customer";
        long start =System.currentTimeMillis();
        int count = 1;
        CountDownLatch downLatch = new CountDownLatch(count);
        for(int i=0;i<count;i++) {
            new Thread(new DoTest(sql,downLatch)).start();
        }
        try {
            downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("总耗时："+(System.currentTimeMillis()-start));
    }

    static class DoTest implements Runnable{
        private String sql;
        private CountDownLatch downLatch;
        public DoTest(String sql, CountDownLatch downLatch) {
            this.sql=sql;
            this.downLatch = downLatch;
        }

        @Override
        public void run() {
            for(int i=0;i<1;i++) {
                List<Customer> list = MysqlQuery.getInstance().executeQuery(sql, Customer.class, null);
                for (Customer customer : list) {
                    System.out.println(customer);
                }
            }
            downLatch.countDown();
        }
    }
}
