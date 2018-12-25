package com.kimigayo.basics.innerclass;

public class Test {
    private interface IHello {
        void sayHello();
    }

    class Hello implements IHello {
        private int i=9;
        public int j=10;
        @Override
        public void sayHello() {
            System.out.println("say Hello!");
        }

        public void sayHello(String str) {
            System.out.println(str);
        }

        private int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static void main(String[] args) {
        Hello hello = new Test().new Hello();
        hello.sayHello();
        Hello testHello = new TestInner().new TestHello(new Test());
        testHello.sayHello();
        testHello.sayHello("what do you do!");
        System.out.println(testHello.j);
        System.out.println(testHello.getJ());
        System.out.println(testHello.getI());
        TestInner.TestHello testHello2 = new TestInner().new TestHello(new Test());
        testHello2.sayHello();
        testHello2.sayHello("what do you do!");
        System.out.println(testHello2.j);
        System.out.println(testHello2.getJ());
        System.out.println(testHello2.getI());
    }
}
