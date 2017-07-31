package com.inteview.corejava;

import org.junit.Test;

/**
 * Created by linxing on 30/07/2017.
 */
public class FoodTest {

    @Test
    public void staticMethodtest() {
        FoodA foodA = InterfaceWithStaticMethod.create(Laziji::new);

        // laziji
        foodA.defaultMethod();
    }
}
