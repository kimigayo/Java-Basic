package com.kimigayo.jvm.classloader;

public class SelfClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        SelfClassLoader classLoader1 = new SelfClassLoader("E:\\");
        SelfClassLoader classLoader2 = new SelfClassLoader("E:\\");
//        System.out.println(classLoader1.getParent().getParent());
        Class<?> aClass1 = classLoader1.loadClass("com.kimigayo.jvm.classloader.Person");
        Class<?> aClass2 = classLoader2.loadClass("com.kimigayo.jvm.classloader.Person");
        System.out.println(aClass1.getClassLoader());
        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());
    }
}
