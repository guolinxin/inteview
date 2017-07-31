package com.inteview.corejava;

/**
 * Created by linxing on 30/07/2017.
 */

@FunctionalInterface
public interface FoodB extends FoodA {
    void method();

    @Override
    default void defaultMethod(){
        System.out.println("default method");
    }
}
