package com.kimigayo.gof23.creator.builder;

import creator.builder.director.AodiCarDirector;
import creator.builder.director.CarDirector;
import creator.builder.factory.AotuoCarFactory;
import creator.builder.product.Car;

/**建造者模式
 * Created by chenbinbin on 2018/2/7.
 */
public class BuilderTest {
    public static void main(String[] args) {
        CarDirector carDirector = new AodiCarDirector(new AotuoCarFactory());
        Car car = carDirector.createCar();
        car.run();
    }
}
