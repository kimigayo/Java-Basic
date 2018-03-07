package com.kimigayo.gof23.creator.builder.director;

import creator.builder.component.Engine;
import creator.builder.component.Seat;
import creator.builder.component.Tyre;
import creator.builder.factory.CarFactory;
import creator.builder.product.Car;

/**
 * Created by chenbinbin on 2018/2/8.
 */
public abstract class AbstractCarDirector implements CarDirector {
    private CarFactory factory;

    public AbstractCarDirector(CarFactory factory) {
        this.factory = factory;
    }

    public Car createCar(){
        Engine engine = factory.createEngine();
        Seat seat = factory.createSeat();
        Tyre tyre = factory.createTyre();
        return directorCar(seat,tyre,engine);
    }

    protected abstract Car directorCar(Seat seat, Tyre tyre, Engine engine);
}
