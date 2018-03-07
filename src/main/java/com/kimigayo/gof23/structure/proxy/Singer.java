package com.kimigayo.gof23.structure.proxy;

/**
 * Created by chenbinbin on 2018/2/10.
 */
public class Singer implements IArtist {
    @Override
    public void sing() {
        System.out.println("歌星唱歌！");
    }

    @Override
    public void dance() {
        System.out.println("歌星跳舞!");
    }
}
