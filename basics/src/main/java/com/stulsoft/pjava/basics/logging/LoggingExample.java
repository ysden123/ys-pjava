/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logging examples
 *
 * @author Yuriy Stul
 */
class LoggingExample {
    private static Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.debug("format {} {}", "param1", 1);
        logger.error("format {} {}", "param1", 1);
        logger.info("format {} {}", "param1", 1);
        logger.trace("format {} {}", "param1", 1);
        logger.warn("format {} {}", "param1", 1);
    }
}
