/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pjava.java10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Playing with var
 *
 * @author Yuriy Stul
 */
public class Vars {
    private static final Logger logger = LoggerFactory.getLogger(Vars.class);

    public static void main(String[] args) {
        logger.info("==>main");
        var i = 123;
        logger.info("i={}", i);

        final var list=new ArrayList<String>();
        list.add("1111");
        list.add("2222");
        logger.debug("list: {}",list.toString());

        var c=List.of("1111","ffff");
        logger.debug("c: {}",c.toString());

        var c2=List.of(1111,2222);
        logger.debug("c2: {}",c2.toString());
        logger.info("<==main");
    }
}
