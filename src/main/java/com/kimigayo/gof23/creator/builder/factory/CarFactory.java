package com.kimigayo.gof23.creator.builder.factory;

import creator.builder.component.Engine;
import creator.builder.component.Seat;
import creator.builder.component.Tyre;

/**
 * Created by chenbinbin on 2018/2/8.
 */
public interface CarFactory {
    Engine createEngine();
    Seat createSeat();
    Tyre createTyre();
}
