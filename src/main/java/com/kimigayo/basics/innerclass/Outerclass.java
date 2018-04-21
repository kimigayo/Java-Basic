package com.kimigayo.basics.innerclass;

import java.util.concurrent.LinkedBlockingQueue;

public class Outerclass {
    private int age;
    private LinkedBlockingQueue<Innerclass> logQueue = new LinkedBlockingQueue<>();
    private LinkedBlockingQueue<StaticInnerclass> staticQueues = new LinkedBlockingQueue<>();

    public void add(String name){
        this.logQueue.offer(new Innerclass(name));
        this.staticQueues.offer(new StaticInnerclass(name));
    }

    public LinkedBlockingQueue<Innerclass> getLogQueue() {
        return logQueue;
    }

    public LinkedBlockingQueue<StaticInnerclass> getStaticQueues() {
        return staticQueues;
    }

    //类似成员变量
    class Innerclass{
        private String name;

        public Innerclass(String name) {
            this.name = name;
        }

        public /*static*/ void run(){
            //可访问外部类私有变量
            System.out.println(age);
            System.out.println("NotStatic");
        }
    }

    static class StaticInnerclass{
        private String name;

        public StaticInnerclass(String name) {
            this.name = name;
        }
        public static void sRun(){
            System.out.println("sRun");
        }


        public void run(){
            //不可访问外部类私有变量
//            System.out.println(age);
            System.out.println("run");
        }
    }

}
class Outter{
    public static void main(String[] args) {
        Outerclass outerclass = new Outerclass();
//        Outerclass.Innerclass innerclass = outerclass.new Innerclass();
//        innerclass.run();
//        Outerclass.StaticInnerclass staticInnerclass = new Outerclass.StaticInnerclass();
//        staticInnerclass.run();
//        Outerclass.StaticInnerclass.sRun();
        outerclass.add("张三");
        outerclass.add("李斯");
        outerclass.add("王五");
        System.out.println(outerclass.getLogQueue().size());
        System.out.println(outerclass.getStaticQueues().size());
    }
}
