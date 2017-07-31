package com.inteview.corejava;

/**
 * Created by linxing on 30/07/2017.
 */
@FunctionalInterface
public interface FoodA {
    void method();

    // Interfaces now allow default methods, the implementer may or
    // may not implement (override) them.
    default void defaultMethod(){
        System.out.println("default method");
    }
}
