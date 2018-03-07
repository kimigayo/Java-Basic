package com.kimigayo.gof23.creator.singleton;

/**静态内部类单例
 * 不是静态属性，不会立即加载对象
 * 兼备高效调用及延时加载的优势
 * Created by chenbinbin on 2018/1/30.
 */
public class StaticInnerClassSingleton {
    //加载类是线程安全的，static保证实例只有一个，而且只能被赋值一次，从而保证线程安全
    private static class SingleInnerClassInstance{
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance(){
        return  SingleInnerClassInstance.INSTANCE;
    }

    private StaticInnerClassSingleton(){}
}
