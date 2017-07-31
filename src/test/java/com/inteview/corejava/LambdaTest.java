package com.inteview.corejava;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by linxing on 30/07/2017.
 */
public class LambdaTest {

    @Test
    public void arrayTest() {
        String separator = ",";
        final String separator2 = ",";

        Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));
        // indicate type
        Arrays.asList("e", "f", "g").forEach((String e) -> {
            System.out.println(e);
        });
        // add separator
        Arrays.asList("h", "i", "j").forEach((String e) -> System.out.println(e + separator));
        // final
        Arrays.asList("k", "l", "m").forEach((String e) -> System.out.println(e + separator2));

        // sort
        Arrays.asList("n", "o", "p").sort((e1, e2) -> {
            int result = e1.compareTo(e2);
            System.out.println("result: " + result);
            return result;
        });

        // sort with less code
        List<String> list = Arrays.asList("r", "t", "s");
        list.sort((e1, e2) -> e1.compareTo(e2));

        list.stream().forEach(e -> {
            System.out.println(e);
        });
    }

    @Test
    public void functionalTest(){

    }


}
