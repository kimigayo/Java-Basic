package com.kimigayo.gof23.creator.builder.factory;

import creator.builder.component.*;

/**
 * Created by chenbinbin on 2018/2/8.
 */
public class AotuoCarFactory extends AbstractCarFactory {

    @Override
    public Engine createEngine() {
        return new AotuoEngine();
    }

    @Override
    public Seat createSeat() {
        return new AotuoSeat();
    }

    @Override
    public Tyre createTyre() {
        return new AotuoTyre();
    }
}
