/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.conf;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * Demonstrates usage the TypeSafe Config framework.
 *
 * @author Yuriy Stul
 */
public class Conf1 {
    public static void main(String[] args) {
        System.out.println("==>main");
        Config conf1 = ConfigFactory.load("conf1.conf").getConfig("conf1");
        System.out.println("conf1.getString(\"param1\"): " + conf1.getString("param1"));

        System.out.println("conf1.getString(\"develop.url\"): " + conf1.getString("develop.url"));
        System.out.println("conf1.getString(\"develop.maxNum\"): " + conf1.getString("develop.maxNum"));
        System.out.println("conf1.getString(\"systest.url\"): " + conf1.getString("systest.url"));
        System.out.println("conf1.getString(\"systest.maxNum\"): " + conf1.getString("systest.maxNum"));

        Config develop = conf1.getConfig("develop");
        System.out.println("develop.getString(\"url\"): " + develop.getString("url"));
        System.out.println("develop.getString(\"maxNum\"): " + develop.getString("maxNum"));

        Config systest = conf1.getConfig("systest");
        System.out.println("systest.getString(\"url\"): " + systest.getString("url"));
        System.out.println("systest.getString(\"maxNum\"): " + systest.getString("maxNum"));

        System.out.println("<==main");
    }
}
