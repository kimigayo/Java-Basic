package com.kimigayo.thread;

import java.util.concurrent.Callable;

/**
 * num-- 这个操作并不是原子的，这里面涉及到获取值、自减、赋值的操作并不能同时完成。
 */
public class SimpleCallable implements Callable {
    private int num = 1000;

    public Object call() throws Exception {
        int i = 0;
        while(true) {
            synchronized (this) {
                if (num > 0) {
                    i++;
                    System.out.println(Thread.currentThread().getName() + "==>" + num--);
                }else {
                    break;
                }
            }
        }
        Thread.sleep(2000);
        return Thread.currentThread().getName() + "=" + i;
    }
}
