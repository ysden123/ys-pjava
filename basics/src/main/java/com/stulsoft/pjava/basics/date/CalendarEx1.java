/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.date;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Yuriy Stul
 */
public class CalendarEx1 {
    private static void showDateTime(String name, Calendar calendar) {
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH) + 1;
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);
        final int second = calendar.get(Calendar.SECOND);
        System.out.printf("%s - %s: milliseconds = %d, %d-%d-%d %d:%d:%d%n",
                name,
                calendar.getTime().toString(),
                calendar.getTimeInMillis(),
                year, month, day, hour, minute, second);


    }

    public static void main(String[] args) {
        var calendar1 = Calendar.getInstance();
        var calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(System.currentTimeMillis());
        var calendar3 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        var calendar4 = Calendar.getInstance();
        calendar4.setTimeInMillis(Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis());

        showDateTime("calendar1", calendar1);
        showDateTime("calendar2", calendar2);
        showDateTime("calendar3", calendar3);
        showDateTime("calendar4", calendar4);
    }
}
