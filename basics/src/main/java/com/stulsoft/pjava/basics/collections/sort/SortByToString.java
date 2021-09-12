/*
 * Copyright (c) 2021. Yuriy Stul
 */

package com.stulsoft.pjava.basics.collections.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @author Yuriy Stul
 */
public class SortByToString {
    private static final Logger logger = LoggerFactory.getLogger(SortByToString.class);

    public static void main(String[] args) {
        logger.info("==>main");
        test1();
        test2();
    }

    private static void test1() {
        logger.info("==>test1");

        var objects = Arrays.asList(
                new DataObject2(123, "n 123"),
                new DataObject2(124, "n 124"),
                new DataObject2(125, "n 125"),
                new DataObject2(126, "n 126"),
                new DataObject2(20, "n 20"),
                new DataObject2(12, "n 12"),
                new DataObject2(20201201, "n 12"),
                new DataObject2(20131201, "n 12")
        );
        objects.stream()
                .sorted((o1, o2) -> GeneralComparator.compare(o1.id(), o2.id()))
                .collect(Collectors.toList())
                .forEach(data -> logger.info("{}", data));
    }

    private static void test2() {
        logger.info("==>test2");

        var objects = Arrays.asList(
                new DataObject2(123, "n 123"),
                new DataObject2(124, "n 124"),
                new DataObject2(125, "n 125"),
                new DataObject2(126, "n 126"),
                new DataObject2(20, "n 20"),
                new DataObject2(12, "n 126"),
                new DataObject2(20201201, "n 12"),
                new DataObject2(20131201, "n 12")
        );
        objects.stream()
                .sorted((o1, o2) -> GeneralComparator.compare(o2.id(), o1.id()))
                .collect(Collectors.toList())
                .forEach(data -> logger.info("{}", data));
    }
}
