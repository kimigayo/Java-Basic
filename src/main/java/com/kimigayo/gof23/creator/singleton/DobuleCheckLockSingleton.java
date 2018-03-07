package com.kimigayo.gof23.creator.singleton;

/**
 * 双重检测锁单例
 * 由于编译器优化原因和jvm底层内部模型原因，偶尔会出问题。不建议使用
 * Created by chenbinbin on 2018/1/30.
 */
public class DobuleCheckLockSingleton {
    //延时加载
    private static DobuleCheckLockSingleton dobuleCheckLockSingleton;
    private DobuleCheckLockSingleton(){}

    //同步内容降低大if内部，相比懒汉式提高了效率，不必每次获取对象都进行同步，只有第一次才进行同步创建以后就没必要了
    public static DobuleCheckLockSingleton getInstance(){
        if(dobuleCheckLockSingleton ==null){
            DobuleCheckLockSingleton single;
            synchronized (DobuleCheckLockSingleton.class){
                single = dobuleCheckLockSingleton;
                if(single==null){
                    synchronized (DobuleCheckLockSingleton.class) {
                        if(single==null)
                            single = new DobuleCheckLockSingleton();
                    }
                    dobuleCheckLockSingleton =single;
                }
            }
        }
        return dobuleCheckLockSingleton;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}
