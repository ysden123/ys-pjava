/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.function.argument;

import java.util.HashMap;
import java.util.function.Consumer;

/**
 * @author Yuriy Stul
 */
public class DetachedServicesRunner2 {
    public static void main(String[] args) {
        var detachedServices = new HashMap<String, Consumer<Integer>>();

        IDetachedService2 ds = new DetachedConsumer1();
        detachedServices.put(ds.serviceName(), ds.consumer());
        ds = new DetachedConsumer2();
        detachedServices.put(ds.serviceName(), ds.consumer());
        ds = null;
        System.gc();

        try{
            Thread.sleep(1000);
        }catch(Exception ignore){}

        detachedServices.forEach((name, consumer) -> {
            System.out.printf("Running %s%n", name);
            consumer.accept(123);
        });
    }
}
