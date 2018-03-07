package com.kimigayo.gof23.structure.facade;

public class DragonWellTeaLeaf implements TeaLeaf{
    @Override
    public void pickTeaLeaf() {
        System.out.println("拿出适量龙井茶");
    }
}
