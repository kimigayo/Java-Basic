package com.kimigayo.basics.array;

import java.util.Arrays;

/**
 * 数组是一组相同类型的对象集合
 * 数字是对象
 */
public class Simplearray {
    public static void main(String[] args) {
        int[] a = new int[3];
        int[] b = {1,2,3};
        a[0] = 1;
        a[1] = 1;
        a[2] = 1;
//        a[3] = 1;//执行报错，编译不报错
//        for(int k:b){
//            System.out.println(k);
//        }

        int[][] c = {
                {1},{1,2,3},{1,2,3,4}
        };
        int[][] d = new int[1][];
        System.arraycopy(a,0,b,1,2);
        System.out.println(Arrays.toString(b));
        Arrays.fill(b,0,2,33);
        System.out.println(Arrays.toString(b));
        for(int[] l:c){
            for (int p :l){
                System.out.println(p);
            }
        }
    }
}
