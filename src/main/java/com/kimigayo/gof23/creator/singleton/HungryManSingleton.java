package com.kimigayo.gof23.creator.singleton;

import java.io.Serializable;

/**饿汉式单例
 * Created by chenbinbin on 2018/1/26.
 */
public class HungryManSingleton implements Serializable{
    private final static HungryManSingleton SINGLE = new HungryManSingleton();//类初始化，就马上加载，线程安全，无延时加载
    private HungryManSingleton(){}

    /**
     * 方法无同步，加载效率高
     * @return
     */
    public static HungryManSingleton getInstance(){
        return SINGLE;
    }

    public static void main(String[] args) {
        System.out.println(HungryManSingleton.getInstance());
        System.out.println(HungryManSingleton.getInstance());
        System.out.println(HungryManSingleton.getInstance());
    }
}
