package com.kimigayo.basics.innerclass;

public class Outerclass {
    private int age;

    //类似成员变量
    class Innerclass{
        public /*static*/ void run(){
            //可访问外部类私有变量
            System.out.println(age);
            System.out.println("NotStatic");
        }
    }

    static class StaticInnerclass{
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
        Outerclass.Innerclass innerclass = outerclass.new Innerclass();
        innerclass.run();
        Outerclass.StaticInnerclass staticInnerclass = new Outerclass.StaticInnerclass();
        staticInnerclass.run();
        Outerclass.StaticInnerclass.sRun();
    }
}
