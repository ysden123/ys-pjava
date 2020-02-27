/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.pjava.basics.date;

import java.time.Instant;
import java.util.Date;

/**
 * @author Yuriy Stul
 */
public class UTCTimeEx1 {
    private static void showDateTime(Date date){
        System.out.printf("%s%n", date);
    }
    public static void main(String[] args) {
        var date1 = new Date();
//        var utc = OffsetDateTime.now(ZoneOffset.UTC);
        var utc = Instant.now();
        var date2 = Date.from(utc);

        showDateTime(date1);
        showDateTime(date2);
    }
}
