package com.inteview.corejava;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by linxing on 30/07/2017.
 */
public class CarTest {

    @Test
    public void carCreateTest() {

        // Constructor init
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);

        // Class::static_method
        cars.forEach(Car::collide);

        // Class::method
        cars.forEach(Car::repair);

        // instance::method
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }
}
