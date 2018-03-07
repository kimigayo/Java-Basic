package com.kimigayo.gof23.creator.singleton;

/**
 * 懒汉式单例
 * Created by chenbinbin on 2018/1/30.
 */
public class LazyManSingleton {
    //类加载时，不初始化实例
    private static LazyManSingleton lazyManSingle;

    private LazyManSingleton() {
    }
    //方法同步，调用效率低
    public static synchronized LazyManSingleton getInstance() {
        if (lazyManSingle == null) {
            lazyManSingle = new LazyManSingleton();
        }
        return lazyManSingle;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}
