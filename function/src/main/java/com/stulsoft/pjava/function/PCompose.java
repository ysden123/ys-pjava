/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.pjava.function;

import java.util.function.Function;
import java.util.logging.Logger;

/**
 * Playing with compose.
 *
 * @author Yuriy Stul
 */
class PCompose {
    private static Logger logger = LoggerUtils.getLogger(PCompose.class.getName());

    private static void test1() {
        logger.info(">>>");
        Function<Integer, Integer> f1 = i -> i * 2;
        Function<Integer, Double> f2 = i -> 2.1 * i;
        Function<Integer, Double> fc = f2.compose(f1);
        logger.info(f1.apply(3).toString());
        logger.info(f2.apply(6).toString());
        logger.info(fc.apply(3).toString());
        logger.info("<<<");
    }

    public static void main(String[] args) {
        logger.info(">>>");
        test1();
        logger.info("<<<");
    }
}
