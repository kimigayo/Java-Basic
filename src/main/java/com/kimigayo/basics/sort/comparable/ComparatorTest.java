package com.kimigayo.basics.sort.comparable;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        String[] strings = new String[]{"a","sdas","dd","aa"};
        sort(strings);
        System.out.println(Arrays.toString(strings));
    }

    public static <T extends Comparable> void sort(T[] array) {
        Comparator comparator = new Comparator<T>(){
            @Override
            public int compare(T o1, T o2) {
                int i = o1.toString().length();
                int i1 = o2.toString().length();
                return i-i1;
            }

        };
        for (int i = 0; i < array.length; i++) {
            boolean sorted = true;//若未曾移位，跳出异常
            for (int j = 1; j < array.length - i; j++) {
                if (comparator.compare(array[j],array[j-1])>0) {
                    T temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }
}
