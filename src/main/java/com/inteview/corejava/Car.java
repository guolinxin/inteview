package com.inteview.corejava;

import java.util.function.Supplier;

/**
 * Created by linxing on 30/07/2017.
 */
public class Car {

    public static Car create(Supplier<Car> carSupplier){
        return carSupplier.get();
    }

    public static void collide( final Car car ) {
        System.out.println( "Collided " + car.toString() );
    }

    public void follow( final Car another ) {
        System.out.println( "Following the " + another.toString() );
    }

    public void repair() {
        System.out.println( "Repaired " + this.toString() );
    }
}
