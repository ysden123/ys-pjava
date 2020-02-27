/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.collections;

import com.stulsoft.pjava.basics.LoggerUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Playing with map.
 * <p>
 * Usage <i>map</i> and <i>flatMap</i>
 *
 * @author Yuriy Stul
 */
public class PMap2 {
    private static Logger logger = LoggerUtils.getLogger(PMap2.class.getName());

    private Collection<String> getCollection() {
        Stream.Builder<String> b = Stream.builder();
        IntStream.range(1, 4).forEach(i -> b.accept(String.format("text %02d", i)));
        return b.build().collect(Collectors.toList());
    }

    private List<List<String>> getCollections() {
        Stream.Builder<List<String>> b1 = Stream.builder();
        IntStream.range(1, 4).forEach(i -> {
            Stream.Builder<String> b2 = Stream.builder();
            IntStream.range(1, 4).forEach(j -> b2.accept(String.format("text %02d - %02d", i, j)));
            b1.accept(b2.build().collect(Collectors.toList()));
        });
        return b1.build().collect(Collectors.toList());
    }

    private List<HashMap<String, Integer>> getMaps() {
        Stream.Builder<HashMap<String, Integer>> b = Stream.builder();
        IntStream.range(1, 4).forEach(i -> {
            HashMap<String, Integer> m = new HashMap<>();
            IntStream.range(1, 4).forEach(j -> m.put(String.format("text %02d - %02d", i, j), i + j));
            b.accept(m);
        });
        return b.build().collect(Collectors.toList());
    }

    /**
     * Usage the <i>map</i> - simple conversion from T1 (String) to T2 (Integer).
     */
    private void testMap1() {
        logger.info(">>>");
        Collection<String> l = getCollection();
        logger.info(l.stream().map(String::hashCode).collect(Collectors.toList()).toString());
        logger.info("<<<");
    }

    /**
     * Usage the <i>flatMap</i> - conversion from list of lists to one list without changing type.
     */
    private void testFlatMap1() {
        logger.info(">>>");
        List<List<String>> l = getCollections();
        logger.info(l.stream().flatMap(List::stream).collect(Collectors.toList()).toString());
        logger.info("<<<");
    }

    /**
     * Usage the <i>flatMap</i> - conversion from list of maps to list of values.
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
