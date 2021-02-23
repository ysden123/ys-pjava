/*
 * Copyright (c) 2021. Yuriy Stul
 */

package com.stulsoft.pjava.basics.collections.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yuriy Stul
 */
public class SortEx2 {
    private static final Logger logger = LoggerFactory.getLogger(SortEx2.class);

    public static void main(String[] args) {
        logger.info("==>main");
        ex1();
        ex2();
        ex3();
        ex4();
    }

    private static void ex1() {
        logger.info("==>ex1");
        var objects = new Object[]{new Integer(1), new Integer(33), new Integer(2)};

        var list = Arrays.asList(objects);

        logger.info("Before sort: {}", list);

        list.sort(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer) {
                    return Integer.compare((Integer) o1, (Integer) o2);
                } else
                    return 0;
            }
        });

        logger.info("After sort: {}", list);

    }

    private static void ex2() {
        logger.info("==>ex2");
        var objects = new Object[]{new Integer(1), new Integer(33), 2};

        var list = Arrays.asList(objects);

        logger.info("Before sort: {}", list);

        list.sort(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer) {
                    return Integer.compare((Integer) o1, (Integer) o2);
                } else
                    return 0;
            }
        });

        logger.info("After sort: {}", list);

    }

    private static void ex3() {
        logger.info("==>ex3");
        var objects = new Object[]{new Integer(1), new Integer(33), new Boolean(true)};

        var list = Arrays.asList(objects);

        logger.info("Before sort: {}", list);

        list.sort(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer) {
                    return Integer.compare((Integer) o1, (Integer) o2);
                } else
                    return 0;
            }
        });

        logger.info("After sort: {}", list);

    }

    private static void ex4() {
        logger.info("==>ex4");
        var objects = new Object[]{"asdadsads", "xyz", "WWW ff", "hjkhkj", "WWW"};

        var list = Arrays.asList(objects);

        logger.info("Before sort: {}", list);

        list.sort(new MyComparator());

        logger.info("After sort: {}", list);

    }

    static class MyComparator implements Comparator<Object> {
        @Override
        public int compare(Object o1, Object o2) {
            if (o1 instanceof Integer && o2 instanceof Integer)
                return Integer.compare((Integer) o1, (Integer) o2);
            else if (o1 instanceof Long && o2 instanceof Long)
                return Long.compare((Long) o1, (Long) o2);
            else if (o1 instanceof String && o2 instanceof String)
                return ((String) o1).compareTo((String) o2);
            else if (o1 instanceof Boolean && o2 instanceof Boolean)
                return ((Boolean) o1).compareTo((Boolean) o2);
            return 0;
        }
    }
}
