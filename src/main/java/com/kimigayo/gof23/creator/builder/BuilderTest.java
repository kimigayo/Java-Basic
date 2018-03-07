package com.kimigayo.gof23.creator.builder;

import com.kimigayo.gof23.creator.builder.director.AodiCarDirector;
import com.kimigayo.gof23.creator.builder.director.CarDirector;
import com.kimigayo.gof23.creator.builder.factory.AotuoCarFactory;
import com.kimigayo.gof23.creator.builder.product.Car;

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
