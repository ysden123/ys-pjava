/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pjava.basics.optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.Optional;

/**
 * @author Yuriy Stul
 */
public class MapVsFlatMap {
    private static final Logger logger = LoggerFactory.getLogger(MapVsFlatMap.class);

    public static void main(String[] args) {
        logger.info("==>main");
        mapAndFlatMapTest();
    }

    private static void mapAndFlatMapTest(){
        logger.info("==>mapAndFlatMapTest");
        func("text 1");
        func(null);
    }

    private static void func(String text){
        logger.info("text is {}", text);
        logger.info("1 {}", Optional.ofNullable(text).map(s -> s.toUpperCase(Locale.ROOT)));
        logger.info("2 {}", Optional.ofNullable(text).map(s -> Optional.of(s.toUpperCase(Locale.ROOT))));
        logger.info("3 {}", Optional.ofNullable(text).flatMap(s -> Optional.of(s.toUpperCase(Locale.ROOT))));

    }
}
