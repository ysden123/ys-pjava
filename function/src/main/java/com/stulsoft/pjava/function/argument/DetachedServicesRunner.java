/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.function.argument;

import java.util.HashMap;
import java.util.function.Function;

/**
 * @author Yuriy Stul
 */
public class DetachedServicesRunner {
    public static void main(String[] args) {
        var detachedServices = new HashMap<String, Function<Integer, String>>();

        IDetachedService ds = new DetachedService1();
        detachedServices.put(ds.serviceName(), ds.transformer());
        ds = new DetachedService2();
        detachedServices.put(ds.serviceName(), ds.transformer());
        ds = new DetachedService3();
        detachedServices.put(ds.serviceName(), ds.transformer());
        ds = null;
        System.gc();

        try{
            Thread.sleep(1000);
        }catch(Exception ignore){}

        detachedServices.forEach((name, transformer) -> System.out.printf("%s -> %s%n", name, transformer.apply(123)));
    }
}
