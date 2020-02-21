/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.date;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yuriy Stul
 * @since 5/1/2018
 */
public class UnixTime {
    public static void main(String[] args) {
        try {
//            Date d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1970-01-18 15:39:31");
//            System.out.println(d);
//            long t = d.getTime();
//            Date d2 = new Date(t*1000L);
//            System.out.println(d2);
//
//            Date d3 = new Date(0L);
//            System.out.println(d3);
//
            Date d4 = new Date(1525238259L);
            System.out.println(d4);

            Date d5 = new Date(1525238259L / 1000L);
            System.out.println(d5);

            Date d6 = new Date(1525238259L * 1000L);
            System.out.println(d6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
