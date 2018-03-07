package com.kimigayo.gof23.structure.bridge;

/**桥接模式
 * 应用场景：JDBC驱动程序
 * 应用要点：处理多层继承结构，处理多维度变化的场景，将各维度设计成独立的继承结构，使各个维度可以独立的扩展在抽象层建立关联
 * Created by chenbinbin on 2018/2/10.
 */
public class Computer {
    private Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

    public void play(){
        brand.getBrand();
    }
    public static class ComputerTest{
        public static void main(String[] args) {
            new Desktop(new Lenovo()).play();
            new Lantop(new Shenzhou()).play();
        }
    }
}
