/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.pjava.basics.collections;

import com.stulsoft.pjava.basics.LoggerUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author Yuriy Stul
 */
public class PMap2 {
    private static Logger logger = LoggerUtils.getLogger(PMap2.class.getName());

    private Collection<String> getCollection() {
        List<String> l = new ArrayList<>();
        for (int i = 1; i <= 3; ++i) {
            l.add(String.format("text %02d", i));
        }

        return l;
    }

    private List<List<String>> getCollections() {
        List<List<String>> l1 = new ArrayList<>();
        for (int i = 1; i <= 3; ++i) {
            List<String> l2 = new ArrayList<>();
            for (int j = 1; j <= 3; ++j) {
                l2.add(String.format("text %02d - %02d", i, j));
            }
            l1.add(l2);
        }
        return l1;
    }

    private List<HashMap<String, Integer>> getMaps() {
        List<HashMap<String, Integer>> l1 = new ArrayList<>();
        for (int i = 1; i <= 3; ++i) {
            HashMap<String, Integer> m = new HashMap<>();
            for (int j = 1; j <= 3; ++j) {
                m.put(String.format("text %02d - %02d", i, j), i + j);
            }
            l1.add(m);
        }
        return l1;
    }

    /**
     * Using map - simple conversion from T1 (String) to T2 (Integer).
     */
    private void testMap1() {
        logger.info(">>>");
        Collection<String> l = getCollection();
        logger.info(l.stream().map(String::hashCode).collect(Collectors.toList()).toString());
        logger.info("<<<");
    }

    /**
     * Using flatMap - conversion from list of lists to one list without changing type.
     */
    private void testFlatMap1() {
        logger.info(">>>");
        List<List<String>> l = getCollections();
        logger.info(l.stream().flatMap(List::stream).collect(Collectors.toList()).toString());
        logger.info("<<<");
    }

    /**
     * Using flatMap - conversion from list of maps to list of values.
     */
    private void testFlatMap2() {
        logger.info(">>>");
        List<HashMap<String, Integer>> m = getMaps();
        logger.info(m.stream().flatMap(x -> x.values().stream()).collect(Collectors.toList()).toString());
        logger.info("<<<");
    }

    public static void main(String[] args) {
        logger.info(">>>");
        PMap2 m = new PMap2();
        m.testMap1();
        m.testFlatMap1();
        m.testFlatMap2();
        logger.info("<<<");
    }
}
