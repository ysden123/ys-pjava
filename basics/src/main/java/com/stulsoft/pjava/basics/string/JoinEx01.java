/*
 * Copyright (c) 2021. Yuriy Stul
 */

package com.stulsoft.pjava.basics.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Yuriy Stul
 */
public class JoinEx01 {
    private static final Logger logger = LoggerFactory.getLogger(JoinEx01.class);

    public static void main(String[] args) {
        logger.info("==>main");
        test1();
        test2();
    }

    /**
     * Last item is not empty string
     */
    private static void test1(){
        logger.info("==>test1");
        var items = new String[]{"1", "2", "3"};
        var join = String.join("|", items);
        logger.info("join: [{}]", join);
    }

    /**
     * Last item is empty string
     */
    private static void test2(){
        logger.info("==>test2");
        var items = new String[]{"1", "2", "3", ""};
        var join = String.join("|", items);
        logger.info("join: [{}]", join);
    }
}
