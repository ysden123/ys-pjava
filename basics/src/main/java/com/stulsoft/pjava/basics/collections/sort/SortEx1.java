/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.collections.sort;

import com.stulsoft.pjava.basics.collections.DataObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Demonstrates sort by multiple fields and grouping
 *
 * @author Yuriy Stul
 */
public class SortEx1 {
    private static final Logger logger = LoggerFactory.getLogger(SortEx1.class);

    public static void main(String[] args) {
        ex1();
        ex2();
    }

    /**
     * Sort original list
     */
    private static void ex1() {
        logger.info("==>ex1");
        var list = Arrays.asList(
                new DataObject("n1", 2, 2),
                new DataObject("n2", 2, 4),
                new DataObject("n1", 1, 3)
        );

        logger.info("Before sort: {}", list);

        list.sort(Comparator.comparing(DataObject::name)
                .thenComparing(DataObject::age));
        logger.info("After sort: {}", list);
    }

    /**
     * Sort and group in stream.
     */
    private static void ex2() {
        logger.info("==>ex2");
        var list = Arrays.asList(
                new DataObject("n1", 2, 2),
                new DataObject("n2", 2, 4),
                new DataObject("n1", 1, 3)
        );

        logger.info("Before sort: {}", list);

        var grouped = list
                .stream()
                .sorted(Comparator.comparing(DataObject::name)
                        .thenComparing(DataObject::age))
                .collect(Collectors.groupingBy(DataObject::name));

        logger.info("After sort and grouping: {}", grouped);
    }
}
