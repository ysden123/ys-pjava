/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.collections.groupby;

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
        logger.info("==>main");
        List<DataObject> list = Arrays.asList(
                new DataObject("n1", 1),
                new DataObject("n1", 2),
                new DataObject("n2", 2));
        Map<Integer, List<DataObject>> grouped = list
                .stream()
                .collect(Collectors.groupingBy(DataObject::getAge));

        logger.info("grouped: {}", grouped);
    }
}
