package com.kimigayo.basics.collection;

import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add("望海路");
        vector.add("观日路");
        vector.add("金山路");
        Enumeration enumeration = vector.elements();
//        while (enumeration.hasMoreElements())
//            System.out.println(enumeration.nextElement());

        String address = "望海路，观日路，金山路";
        StringTokenizer tokenizer = new StringTokenizer(address,"，");
        while(tokenizer.hasMoreElements()){
            System.out.println(tokenizer.nextElement());
        }
    }
}
