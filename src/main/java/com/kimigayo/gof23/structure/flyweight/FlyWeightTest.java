package com.kimigayo.gof23.structure.flyweight;

/**
 * 享元模式
 * 应用场景：线程池、数据库连接池、String类的设计
 * 核心：以共享的方式高效的支持大量细粒度对象的重用
 * 关键词{
 *     内部状态：可以共享，不随环境的变化而改变
 *     外部状态：不可以共享，会碎环境的变化而改变
 * }
 * 优点：
 *      极大减少内存中对象的数量
 *      相同或相似的对象只存一份，极大的节约资源，提高系统性能
 *      外部状态相对独立，不影响内部状态
 * 缺点：
 *      模式较为复杂，使得程序逻辑复杂化
 *      为了节省内存，共享了内部状态，分离了外部状态，而读取外部状态使运行时间变长。用时间换取空间
 */
public class FlyWeightTest {
    public static void main(String[] args) {
        Flyweight flyweight = FlyweightFactory.getFlyweight("jack");
        Flyweight flyweight2 = FlyweightFactory.getFlyweight("jack");
        flyweight.getAge(new UnsharedConreteFlyweight(20));
        flyweight2.getAge(new UnsharedConreteFlyweight(22));
        System.out.println(flyweight);
        System.out.println(flyweight2);
        System.out.println(FlyweightFactory.getSize());
    }
}
