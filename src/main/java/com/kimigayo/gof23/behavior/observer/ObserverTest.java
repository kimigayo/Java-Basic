package com.kimigayo.gof23.behavior.observer;

public class ObserverTest {
    public static void main(String[] args) {
//        ConcreteObserver o1 = new ConcreteObserver();
////        ConcreteObserver o2 = new ConcreteObserver();
////        ConcreteObserver o3 = new ConcreteObserver();
////        ConcreteSubject subject = new ConcreteSubject();
////        subject.getList().add(o1);
////        subject.getList().add(o2);
////        subject.getList().add(o3);
////        System.out.println(o1.getState());
////        System.out.println(o2.getState());
////        System.out.println(o3.getState());
////        subject.setState(500);
////        System.out.println(o1.getState());
////        System.out.println(o2.getState());
////        System.out.println(o3.getState());
            test();
    }

    public static void test(){
        ConcreteObserver2 o1 = new ConcreteObserver2();
        ConcreteObserver2 o2 = new ConcreteObserver2();
        ConcreteObserver2 o3 = new ConcreteObserver2();
        ConcreteSubject2 subject = new ConcreteSubject2();
        subject.addObserver(o1);
        subject.addObserver(o2);
        subject.addObserver(o3);
        System.out.println(o1.getState());
        System.out.println(o2.getState());
        System.out.println(o3.getState());
        subject.setState(500);
        System.out.println(o1.getState());
        System.out.println(o2.getState());
        System.out.println(o3.getState());
    }
}
