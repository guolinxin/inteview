package com.inteview.corejava;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by linxing on 31/07/2017.
 */
public class ParallelSortTest {

    @Test
    public void sortTest(){

        long[] arrayOfLong = new long[20000];

        Arrays.parallelSetAll(
                arrayOfLong,
                index ->
                        // generate 0-1000000 random number
                        ThreadLocalRandom
                        .current()
                .nextInt(1000000
                )
        );

        System.out.println(arrayOfLong.length);

        // first 10
        Arrays.stream(arrayOfLong)
                // set limit
                .limit(10)
                .forEach(i -> System.out.println(i + " " ));

        // sort
        Arrays.parallelSort(arrayOfLong);
        // print after sort

        Arrays.stream(arrayOfLong)
                .limit(10)
                .forEach(i -> System.out.println(i + " "));

    }
}
