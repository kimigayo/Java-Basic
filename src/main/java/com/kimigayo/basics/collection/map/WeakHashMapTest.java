package com.kimigayo.basics.collection.map;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class WeakHashMapTest {
    public static void main(String[] args) {
        WeakHashMap<String,String> hashMap = new WeakHashMap<>();
        hashMap.put("a","b");//String内部实现为常量数组，属于强引用
        hashMap.put(new String("ab"),"b");
        hashMap.put(new String("abc"),"b");
        hashMap.put("abcd","b");
        System.gc();
        System.runFinalization();
        System.out.println(hashMap.size());
    }

    /**
     * 强引用：StrongReference gc运行时不回收
     * 软引用：SoftReference gc运行时可能回收（jvm内存不够时回收）
     * 弱引用：WeakReference gc运行时回收
     * 虚引用：PhantonReference 类似于无引用，主要跟踪对象被回收的状态，不单独使用，必须与引用队列（ReferenceQueue）联合使用
     */
    public void testQuote(){
        WeakReference reference1 = new WeakReference("软件园");//强引用
        WeakReference reference2 = new WeakReference(new String("软件园"));//弱引用
        System.gc();
        System.runFinalization();
        System.out.println(reference1.get());
        System.out.println(reference2.get());
    }
}
