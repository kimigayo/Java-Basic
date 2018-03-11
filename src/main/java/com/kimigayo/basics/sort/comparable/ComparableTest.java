package com.kimigayo.basics.sort.comparable;

import java.util.Arrays;

public class ComparableTest {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1,3,4,1,32,2};
        sort(integers);
        System.out.println(Arrays.toString(integers));
    }

    public static <T extends Comparable> void sort(T[] array){

        for (int i=0;i<array.length;i++){
            boolean sorted=true;//若未曾移位，跳出异常
            for(int j=1;j<array.length-i;j++){
                if((((Comparable) array[j - 1]).compareTo(array[j]))<0){
                    T temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    sorted = false;
                }
            }
            if (sorted){
                break;
            }
        }
    }
}
