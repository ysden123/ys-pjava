/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pjava.basics.date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

/**
 * @author Yuriy Stul
 */
public class Timestamp1 {
    private static Logger logger = LoggerFactory.getLogger(Timestamp1.class);

    public static void main(String[] args) {
        logger.info("==>main");
        f1();
        f2();
        f3();
        logger.info("<==main");
    }

    private static void f1() {
        logger.info("==>f1");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        logger.info("timestamp: {}",
                new SimpleDateFormat("yyyyMMddHHMM").format(timestamp));
        logger.info("<==f1");
    }

    private static void f2() {
        logger.info("==>f2");
        var instant = Instant.now();
        logger.info("instant: {}", instant.toEpochMilli());
        logger.info("<==f2");
    }

    private static void f3() {
        logger.info("==>f3");
        var now = LocalDateTime.now();
        var result = String.format("%d_%02d_%02d", now.getHour(), now.getMinute(), now.getSecond());
        logger.info("result: {}", result);
        logger.info("<==f3");
    }
}
