package com.kimigayo.gof23.structure.bridge;

/**
 * Created by chenbinbin on 2018/2/10.
 */
public class Lantop extends Computer {
    public Lantop(Brand brand) {
        super(brand);
    }

    @Override
    public void play() {
        super.play();
        System.out.println("笔记本");
    }
}
