/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Checking, if convert to stream increases the memory usage
 *
 * @author Yuriy Stul
 */
public class ArrayStreamAndMemory {
    private static final Logger logger = LoggerFactory.getLogger(ArrayStreamAndMemory.class);

    static class SomeData {
        String name;
        Integer length;

        public SomeData(String name, Integer length) {
            this.name = name;
            this.length = length;
        }

        public Integer getLength() {
            return length;
        }
    }

    static void test1() {
        logger.info("==>test1");
        var instance = Runtime.getRuntime();
        var mb = 1024 * 1024;
        var n = 10000000;
        var memStart = instance.totalMemory() - instance.freeMemory();
        var arr = new SomeData[n];
        for (var i = 0; i < n; ++i) {
            arr[i] = new SomeData("n " + i, i);
        }
        var memAfterArray = instance.totalMemory() - instance.freeMemory();
        var stream = Arrays.stream(arr);
        stream.mapToInt(SomeData::getLength).sum();
        var memAfterStream = instance.totalMemory() - instance.freeMemory();
        logger.info("used after start  = {} MB", memStart / mb);
        logger.info("used after array  = {} MB", memAfterArray / mb);
        logger.info("used after stream = {} MB", memAfterStream / mb);
        logger.info("<==test1");
    }

    static void test2() {
        logger.info("==>test2");
        var instance = Runtime.getRuntime();
        var mb = 1024 * 1024;
        var n = 10000000;
        var memStart = instance.totalMemory() - instance.freeMemory();
        var col = new ArrayList<SomeData>();
        for (var i = 0; i < n; ++i) {
            col.add(new SomeData("n " + i, i));
        }
        var memAfterCollection = instance.totalMemory() - instance.freeMemory();
        var stream = col.stream();
        stream.mapToInt(SomeData::getLength).sum();
        var memAfterStream = instance.totalMemory() - instance.freeMemory();
        logger.info("used after start      = {} MB", memStart / mb);
        logger.info("used after collection = {} MB", memAfterCollection / mb);
        logger.info("used after stream     = {} MB", memAfterStream / mb);
        logger.info("<==test2");
    }

    public static void main(String[] args) {
        logger.info("==>main");
        test1();
        test2();
        logger.info("<==main");
    }
}
