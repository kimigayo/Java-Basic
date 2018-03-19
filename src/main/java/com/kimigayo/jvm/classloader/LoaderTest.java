package com.kimigayo.jvm.classloader;

/**
 * OSGI加载器，每个bundle都使用一个加载器
 */
public class LoaderTest {
    public static void main(String[] args) {
        System.out.println(LoaderTest.class.getClassLoader());
        System.out.println(LoaderTest.class.getClassLoader().getParent());
        System.out.println(LoaderTest.class.getClassLoader().getParent().getParent());
        String s="aa";//类加载器支持”双亲委托“代理模式（先从最父级的加载器范围内查看是否为加载范围），这也是为了保证java核心库的类型安全
        //当然并不是所有的类加载器都是采用双亲委托的机制，如：tomcat的类加载器机制刚好与双亲委托机制相反
    }
}
