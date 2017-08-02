package com.inteview;

import org.junit.Test;

/**
 * Created by linxing on 01/08/2017.
 */
public class cognito {

    @Test
    public void outPutTest() {
        int sum = 0;
        int count = 1;

        while (count <= 5) {
            sum += count;
            count++;
        }
        System.out.println(sum);
    }

    @Test
    public void bikePrintTest(){

        class Bike{
            int speedlimit = 90;
        }

        class HondaBike extends Bike {
            int speedlimit = 150;
            Bike bike = new HondaBike();

        }


    }
}
