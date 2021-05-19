/*
 * Copyright (c) 2021. Yuriy Stul
 */

package com.stulsoft.pjava.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Yuriy Stul
 */
public class ArrayOfConsumers {
    private List<Consumer<Void>> consumers = new ArrayList<>();

    public ArrayOfConsumers(){
        init();
    }

    private Consumer<Void> c1 = __ -> {
      System.out.println("c1");
    };
    private Consumer<Void> c2 = __ -> {
      System.out.println("c2");
    };

    private void init(){
        consumers.add(c1);
        consumers.add(c2);
    }

    private void run(){
        consumers.forEach(consumer -> consumer.accept(null));
    }

    public static void main(String[] args) {
        System.out.println("==>main");
        var arrayOfConsumers = new ArrayOfConsumers();

        arrayOfConsumers.run();

        System.out.println("<==main");
    }
}
