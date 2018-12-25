package com.kimigayo.basics.innerclass;

import jdk.internal.org.objectweb.asm.Handle;

public class TestInner {
    class TestHello extends Test.Hello{
        private int i=11;
        public int j=12;
        public TestHello(Test test) {
            test.super();
        }
        public void sayHello(String str){
            System.out.println("Test say "+str);
        }

        @Override
        public int getI() {
            return i;
        }

        @Override
        public int getJ() {
            return j;
        }
    }
}
