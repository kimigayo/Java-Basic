package com.kimigayo.gof23.creator.builder.director;

import creator.builder.component.Engine;
import creator.builder.component.Seat;
import creator.builder.component.Tyre;
import creator.builder.factory.CarFactory;
import creator.builder.product.Aodi;
import creator.builder.product.Car;

/**
 * Created by chenbinbin on 2018/2/8.
 */
public class AodiCarDirector extends AbstractCarDirector {
    public AodiCarDirector(CarFactory factory) {
        super(factory);
    }

    @Override
    protected Car directorCar(Seat seat, Tyre tyre, Engine engine) {
        return new Aodi(engine,seat,tyre);
    }
}
