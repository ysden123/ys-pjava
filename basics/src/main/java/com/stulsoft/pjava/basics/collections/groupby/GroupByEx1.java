/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.collections.groupby;

import com.stulsoft.pjava.basics.collections.DataObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Example of usage the groupingBy
 *
 * @author Yuriy Stul
 */
public class GroupByEx1 {
    private static final Logger logger = LoggerFactory.getLogger(GroupByEx1.class);

    public static void main(String[] args) {
        ex1();
        ex2();
    }

    /**
     * Grouping by one field
     */
    private static void ex1(){
        logger.info("==>ex1");
        List<DataObject> list = Arrays.asList(
                new DataObject("n1", 1,20),
                new DataObject("n1", 2, 30),
                new DataObject("n2", 2, 40));
        Map<Integer, List<DataObject>> grouped = list
                .stream()
                .collect(Collectors.groupingBy(DataObject::age));

        logger.info("grouped: {}", grouped);
    }

    /**
     * Grouping by two fields
     */
    private static void ex2(){
        logger.info("==>ex2");
        List<DataObject> list = Arrays.asList(
                new DataObject("n1", 1,20),
                new DataObject("n3", 3,20),
                new DataObject("n1", 2, 30),
                new DataObject("n2", 2, 40));
        Map<Integer, Map<String, List<DataObject>>> grouped = list
                .stream()
                .collect(Collectors.groupingBy(DataObject::age,
                        Collectors.groupingBy(DataObject::name)));

        logger.info("grouped: {}", grouped);
    }
}
