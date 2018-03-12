package com.kimigayo.basics.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 自定义堆栈
 * @param <T>
 */
public class MyDeque<T> {
    private Deque<T> deque = new ArrayDeque();
    private int size;

    public MyDeque(int size) {
        this.size = size;
    }

    public boolean push(T t){
        if(deque.size()>size)
            return false;
        return deque.offer(t);
    }

    public T pop(){
        return deque.pollLast();
    }

    public T peak(){
        return deque.peekLast();
    }

    public static void main(String[] args) {
        MyDeque<String> deque = new MyDeque<String>(3);
        deque.push("观日路");
        deque.push("望海路");
        deque.push("金山路");
        deque.push("环岛干道");
        Object o;
        while((o=deque.pop())!=null){
            System.out.println(o);
        }
    }
}

