/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pjava.basics.optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author Yuriy Stul
 */
public class POptional4 {
    private static final Logger logger = LoggerFactory.getLogger(POptional4.class);

    public static void main(String[] args) {
        logger.info("==>main");
        orElseTest();
        orElseGetTest();
    }

    private static void orElseTest() {
        logger.info("==>orElseTest");
        var opt1 = Optional.of(123);
        var res1 = opt1.orElse(4);
        logger.info("opt1={}, res1={}", opt1, res1);
        var opt2 = Optional.empty();
        var res2 = opt2.orElse(4);
        logger.info("opt2={}, res2={}", opt2, res2);
    }

    private static void orElseGetTest(){
        Supplier<Integer> supplier = () -> 4;
        logger.info("==>orElseGetTest");
        var opt1 = Optional.of(123);
        var res1=opt1.orElseGet(supplier);
        logger.info("opt1={}, res1={}", opt1, res1);
        var opt2 = Optional.empty();
        var res2=opt2.orElseGet(supplier);
        logger.info("opt2={}, res2={}", opt2, res2);
    }
}
