package com.kimigayo.gof23.structure.facade;

public class CeramicTeaSet implements  TeaSet{
    @Override
    public void putTeaSet() {
        System.out.println("将茶叶放入茶壶");
    }
}
