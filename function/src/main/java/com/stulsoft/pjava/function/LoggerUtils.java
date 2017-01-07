/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.pjava.function;

import java.util.logging.Logger;

/**
 * @author Yuriy Stul
 */
public class LoggerUtils {
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");
    }

    /**
     * Returns a logger for specified name.
     *
     * @param name the logger's name.
     * @return the logger for specified name.
     */
    static Logger getLogger(String name) {
        return Logger.getLogger(name);
    }
}
