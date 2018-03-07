package com.kimigayo.gof23.structure.bridge;

/**
 * Created by chenbinbin on 2018/2/10.
 */
public class Lenovo implements Brand {
    @Override
    public void getBrand() {
        System.out.println("联想电脑！");
    }
}
