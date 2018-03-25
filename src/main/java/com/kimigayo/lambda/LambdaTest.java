package com.kimigayo.lambda;

import com.google.common.collect.Lists;
import com.google.common.primitives.Doubles;
import com.kimigayo.basics.collection.commons.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LambdaTest {
    @Test
    public void test1(){
        List<Person> list = Lists.newArrayList(new Person("张三",true,14000),new Person("李斯",true,12000),new Person("王五",true,13000));
        Collections.sort(list,(p1,p2)-> Doubles.compare(p1.getSalary(),p2.getSalary()));//单行方法块无需使用{}
        System.out.println(list);
    }


    @Test
    public void test4(){
        List<Person> list = Lists.newArrayList(new Person("张三",true,14000),new Person("李斯",true,12000),new Person("王五",true,13000));
        List<Double> list1 = Lists.newArrayList(12000.0,11000.0,13000.0);
        Collections.sort(list1,Doubles::compare);//方法引用：类::静态方法
        Collections.sort(list,this::compare);//方法引用：对象::方法
        list.forEach(System.out::println);//方法引用：对象::方法
        list1.forEach(System.out::println);//方法引用：对象::方法
    }

    public int compare(Person p1,Person p2){
       return  Doubles.compare(p1.getSalary(),p2.getSalary());
    }


    @Test
    public void test5(){
        //构造方法引用
        List<Person> list = this.asList(LinkedList::new,new Person("zhan",false,11000.0),new Person("li",false,10009));
        list.forEach(System.out::println);
        Personlam person = this.createObject(Personlam::new);
        System.out.println(person);
    }

    public <T> List<T> asList(lambdacon<List<T>> lambdacon,T...people){
        List<T> list = lambdacon.creator();
        for(T person:people)
            list.add(person);
        return list;
    }
    @FunctionalInterface
    interface lambdacon<T extends List>{
        T creator();
    }

    public <T> T createObject(ObjectLam<T> lam){
        return lam.creator();
    }

    @FunctionalInterface
    interface ObjectLam<T extends Object>{
        T creator();
    }
    static class Personlam extends Object{
        public Personlam() {
        }
    }

    @Test
    public void test2(){
        int time = 10;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<time;i++){//这里使用默认对time进行final修饰
//                    System.out.println("hello");
                }
                System.out.println(this);//结果：com.kimigayo.lambda.LambdaTest$1@50e8772，内部类格式$
                //                time=19;//默认为fina
            }
        }).start();
//        time=19;
        System.out.println(this);//结果：com.kimigayo.lambda.LambdaTest@2f7c2f4f
//        System.out.println(time);
    }

    @Test
    public void test3(){
        int time = 10;
        new Thread(()->{
            for (int i=0;i<time;i++){}
            System.out.println(this);//结果：com.kimigayo.lambda.LambdaTest@7880cdf3，与外部类this相等
        }).start();
//        time=19;
        System.out.println(this);//结果：com.kimigayo.lambda.LambdaTest@7880cdf3
//        System.out.println(time);
    }
}
