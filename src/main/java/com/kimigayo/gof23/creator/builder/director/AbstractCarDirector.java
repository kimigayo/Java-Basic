package com.kimigayo.gof23.creator.builder.director;


import com.kimigayo.gof23.creator.builder.component.Engine;
import com.kimigayo.gof23.creator.builder.component.Seat;
import com.kimigayo.gof23.creator.builder.component.Tyre;
import com.kimigayo.gof23.creator.builder.factory.CarFactory;
import com.kimigayo.gof23.creator.builder.product.Car;

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
