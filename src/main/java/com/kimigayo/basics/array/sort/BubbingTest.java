package com.kimigayo.basics.array.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbingTest {
    public static void main(String[] args) {
        int[] ints = new int[]{9,1,3,4,1};
        sort(ints);
    }

    public static void sort(int[] array){
        for (int i=0;i<array.length;i++){
            boolean sorted=true;//若未曾移位，跳出异常
            for(int j=1;j<array.length-i;j++){
                if(array[j-1]>array[j]){
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    sorted = false;
                }
//                System.out.println("\t\t小圈："+Arrays.toString(array));
            }
            System.out.println("\t大圈："+Arrays.toString(array));
            if (sorted){
                break;
            }
        }
    }
}
