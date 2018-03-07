package com.kimigayo.gof23.creator.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**单例模式选择：
 * 实例占用内存较小可以选用：枚举式、饿汉式（不延时加载）
 * 实例占用内存较大可以选用：静态内部类式、懒汉式（延时加载）
 * 双重检测锁不建议使用
 * Created by chenbinbin on 2018/2/7.
 */
public class SingletonTest {

    public static void main(String[] args) throws Exception {
        EnumSingleton enumSingleton = EnumSingleton.instance;
        EnumSingleton[] enumSingleton1 = enumSingleton.getClass().getEnumConstants();
        System.out.println(Arrays.asList(enumSingleton1));
        //通过反射直接创建实例
//        Class<HungryManSingleton> s1 = (Class<HungryManSingleton>) Class.forName("creator.single.HungryManSingleton");
        HungryManSingleton single = HungryManSingleton.getInstance();
        HungryManSingleton single0 = HungryManSingleton.getInstance();
        System.out.println(single);
        System.out.println(single0);
        Class s1 = single.getClass();
        Constructor constructor = s1.getDeclaredConstructor();
        constructor.setAccessible(true);
//        System.out.println(constructor.newInstance());
//        System.out.println(constructor.newInstance());
        //通过反序列化创建实例
        FileOutputStream fileOutputStream = new FileOutputStream("d:/a.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(single);
        objectOutputStream.close();
        fileOutputStream.close();
        FileInputStream fileInputStream = new FileInputStream("d:/a.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        HungryManSingleton single1 = (HungryManSingleton) objectInputStream.readObject();
        System.out.println(single1);
    }
    public static class EfficientTest {
        public static void main(String[] args) throws InterruptedException {
            CountDownLatch countDownLatch = new CountDownLatch(10000);
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 1000000000; i++) {
//                        StaticInnerClassSingleton creator.single = StaticInnerClassSingleton.getInstance();
//                        HungryManSingleton creator.single = HungryManSingleton.getInstance();
//                        LazyManSingleton creator.single = LazyManSingleton.getInstance();
                            EnumSingleton single = EnumSingleton.instance;
                        }
                        countDownLatch.countDown();
                    }
                }).start();
            }
            countDownLatch.await();
            long end = System.currentTimeMillis();
            System.out.println("耗时：" + (end - start) + "ms");
        }
    }
}
