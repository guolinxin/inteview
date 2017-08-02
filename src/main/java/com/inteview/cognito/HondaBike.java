package com.inteview.cognito;

/**
 * Created by linxing on 01/08/2017.
 */
public class HondaBike extends Bike {
    int speedlimit = 150;

    public static void main(String[] args) {
        Bike bike = new HondaBike();
        System.out.println(bike.speedlimit);
    }
}
