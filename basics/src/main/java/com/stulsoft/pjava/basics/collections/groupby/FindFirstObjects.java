/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pjava.basics.collections.groupby;

import com.stulsoft.pjava.basics.collections.DataObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Play with grouping
 *
 * @author Yuriy Stul
 */
public class FindFirstObjects {
    private static final Logger logger = LoggerFactory.getLogger(FindFirstObjects.class);

    private static record Result(long t1, long t2, boolean t1FasterT2) {
    }

    public static void main(String[] args) {
        logger.info("==>main");
        var start = System.currentTimeMillis();
        var dataObjects = Arrays.asList(
                new DataObject("n duplicated", 1, 1),
                new DataObject("n duplicated", 2, 1),
                new DataObject("n2", 1, 1),
                new DataObject("n3", 1, 1),
                new DataObject("n with null", null, 1)
        );
        var results = new LinkedList<Result>();
        for (int i = 1; i <= 2000; ++i) {
            var dataObjectsForTest = new ArrayList<>(dataObjects);
            for (int j = 1; j <= 2000; ++j)
                dataObjectsForTest.add(new DataObject("name " + j, j, j * 2));
            var t1 = test1(dataObjectsForTest);
            var t2 = test2(dataObjectsForTest);
            results.add(new Result(t1, t2, t1 < t2));
        }
        var t1FasterT2 = results.stream().filter(Result::t1FasterT2).count();
        logger.info("t1 is faster than t2 {} ({}%) times in {} tests", t1FasterT2, (t1FasterT2 * 100) / results.size(), results.size());
        logger.info("Duration={} ms", System.currentTimeMillis() - start);
    }

    /**
     * Uses additional list (slowly than test2)
     */
    private static long test1(List<DataObject> dataObjects) {
        var start = System.nanoTime();
        var lastDataObjects = new LinkedList<DataObject>();
        dataObjects.stream()
                .sorted(Comparator.comparing(DataObject::name)
                        .thenComparing(DataObject::age))
                .collect(Collectors.groupingBy(DataObject::name))
                .forEach((key, value) -> lastDataObjects.add(value.get(value.size() - 1)));
//        lastDataObjects.forEach(dataObject -> logger.info("{}", dataObject));
        return System.nanoTime() - start;
    }

    /**
     * Does not use additional list (faster than test1)
     */
    private static long test2(List<DataObject> dataObjects) {
        var start = System.nanoTime();
        var lastDataObjects = dataObjects.stream()
                .sorted(Comparator.comparing(DataObject::name)
                        .thenComparing(DataObject::age))
                .collect(Collectors.groupingBy(DataObject::name))
                .entrySet()
                .stream()
                .map(entry -> entry.getValue().get(entry.getValue().size() - 1))
                .collect(Collectors.toList());
//        lastDataObjects.forEach(dataObject -> logger.info("{}", dataObject));
        return System.nanoTime() - start;
    }
}
