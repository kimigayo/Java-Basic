package com.kimigayo.basics.number;

import java.util.Random;

public class Exponents {
    String str;
    public static void main(String[] args) {
        float expFloat = 1.39e-43f;
        expFloat = 1.39E-43f;
        System.out.println(expFloat);
        double expDouble = 47e47d;
        double expDouble2 = 47E47;
        System.out.println(expDouble);
        byte i = -2;
        System.out.println(Integer.toBinaryString(i));
        i >>>= 25;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
        int s = 100;
        System.out.println(Integer.toBinaryString(s));
        s >>>= 3;
        System.out.println(s);
        System.out.println(Integer.toBinaryString(s));
        System.out.println();
        int k = Integer.MAX_VALUE;
        int l = k * 4;
        System.out.println(l);
        System.out.println(Integer.toHexString(l));
        int o = 3;
        int j = o++ * 2;
        System.out.println(j);
        System.out.println(o);
        for (int y = 1, u = 11; y < 5; ++y, u = y * 2)
            System.out.println(y + "---" + u);
        Random random = new Random(47);
        for (int p = 0; p < 100; p++) {
            int c = random.nextInt(26) + 'a';
            System.out.println((char) c + "," + c + ":");
            switch (c) {
                case 'a':
                case 'e':
                case 'j':
                case 'o':
                case 'u':
                    System.out.println("vowel");
                    break;
                case 'y':
                case 'w':
                    System.out.println("sometimes a vowel");
                    break;
                default:
                    System.out.println("consonant");
            }
        }
        System.out.println(new Exponents().str);
        new Exponents().f(1, new Character[]{'a'});
//        new Exponents().f('a','b');
    }

    void f(float i,Character...args){
        System.out.println("first");
    }
    void f(Character...args){
        System.out.println("second");
    }
}
