package com.kimigayo.gof23.structure.decorator;

/**
 * 装饰器模式
 * 应用场景：IO流底层框架，HttpServletRequestWrapper与桥接模式区别：桥接模式注重类别，装饰器模式注重功能
 */
public class DecoratorTest {
    public static void main(String[] args) {
        new DecorateSofa(new DecorateDesk(new DecorateAirconditioned(new Room()))).decorate();
    }
}
