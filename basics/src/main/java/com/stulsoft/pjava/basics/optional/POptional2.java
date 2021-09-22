/*
 * Copyright (c) 2020. Yuriy Stul
 */
package com.stulsoft.pjava.basics.optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Playing with Optional
 *
 * @author Yuriy Stul.
 */
public class POptional2 {
    private final static Logger logger = LoggerFactory.getLogger(POptional2.class);

    private record DataObject(String name) {
    }

    public static void main(String[] args) {
        logger.info("==>main");
        testF1();
        test2();
        test3();
        logger.info("<==main");
    }

    private static Optional<Integer> f1(boolean tofail) {
        return tofail ? Optional.empty() : Optional.of(123);
    }

    private static void testF1() {
        logger.info("==>testF1");
        Optional<Integer> r = f1(false);
        r.ifPresent(i -> logger.info("(1) Result is {}", i));
        boolean isPresent = r.isPresent();
        logger.info("(1.1) isPresent is {}", isPresent);

        r = f1(true);
        r.ifPresent(i -> logger.info("(2) Result is {}", i));
        isPresent = r.isPresent();
        logger.info("(2.1) isPresent is {}", isPresent);
        logger.info("<==testF1");
    }

    private static void test2() {
        logger.info("==>test2");
        AtomicInteger i = new AtomicInteger();
        Optional.of(123).ifPresent(i::set);
        logger.info("<==test2");
    }

    private static void test3() {
        logger.info("==>test3");
        AtomicReference<DataObject> dataObjectNull = new AtomicReference<>();
        logger.info("{}", dataObjectNull.get());

        AtomicReference<DataObject> dataObject = new AtomicReference<>();
        Optional.of("some name").ifPresent(name -> dataObject.set(new DataObject(name)));
        logger.info("{}", dataObject);
        logger.info("<==test3");
    }
}

