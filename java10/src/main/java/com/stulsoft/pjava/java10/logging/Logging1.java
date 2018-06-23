/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.pjava.java10.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Yuriy Stul
 */
public class Logging1 {
    private static final Logger logger=LoggerFactory.getLogger(Logging1.class);
    public static void main(String[] args) {
        logger.info("==>main");
        var l=new Logging1();
        l.f();
    }
    private void f(){
        logger.info("==>f");
        logger.info("<==f");
    }
}
