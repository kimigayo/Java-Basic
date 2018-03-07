package com.kimigayo.gof23.creator.builder.director;


import com.kimigayo.gof23.creator.builder.component.Engine;
import com.kimigayo.gof23.creator.builder.component.Seat;
import com.kimigayo.gof23.creator.builder.component.Tyre;
import com.kimigayo.gof23.creator.builder.factory.CarFactory;
import com.kimigayo.gof23.creator.builder.product.Aodi;
import com.kimigayo.gof23.creator.builder.product.Car;

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
