package com.inteview.corejava;

import org.junit.Test;

import java.util.Optional;

/**
 * Created by linxing on 30/07/2017.
 */
public class OptionalTest {

    @Test
    public void createTest() {

        // null value
        Optional<String> fullName = Optional.ofNullable(null);

        // shuai
        fullName = Optional.of( "Shuai" );

        System.out.println("Fullname --> " + fullName);
        System.out.println("Fullname.isPresent() --> " + fullName.isPresent());
        // empty
        System.out.println("Optional.empty() --> " + Optional.empty());
        // orElseGet accept method
        System.out.println("Fullname.orElseGet() --> " + fullName.orElseGet(() -> "null value then orElseGet method --> shuai"));
        // orElse accept efault value
        System.out.println(fullName.map( s -> "Hey " + s + "!" ).orElse( "this is shuai!" ));

    }
}
