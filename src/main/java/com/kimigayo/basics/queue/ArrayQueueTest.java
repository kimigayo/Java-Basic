package com.kimigayo.basics.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 队列
 */
public class ArrayQueueTest {
    public static void main(String[] args) {
        Queue queue = new ArrayDeque();
        queue.offer("观日路");
        queue.offer("望海路");
        queue.offer("金山路");
        queue.offer("环岛干道");
        Object o;
        while((o=queue.poll())!=null){
            System.out.println(o);
        }
    }
}
