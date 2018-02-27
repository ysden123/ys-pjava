/*
   Created by Yuriy Stul 2018
*/
package com.stulsoft.pjava.basics.date;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * Playing with {@code Date} and {@code LocalDateTime}
 *
 * @author Yuriy Stul
 */
public class DateToLocalDateTime {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        System.out.println("==>test1");
        Date nowOriginal = new Date();
        Date nowWithoutMinutes = new Date(java.sql.Timestamp.valueOf(
                (new java.sql.Timestamp(nowOriginal.getTime()))
                        .toLocalDateTime()
                        .truncatedTo(ChronoUnit.MINUTES))
                .getTime());
        System.out.printf("nowOriginal = %s, nowWithoutMinutes = %s%n", nowOriginal, nowWithoutMinutes);
        System.out.printf("nowOriginal = %d, nowWithoutMinutes = %d%n", nowOriginal.getTime(), nowWithoutMinutes.getTime());
        System.out.println("<==test1");
    }

    private static void test2() {
        System.out.println("==>test2");
        Date nowOriginal = new Date();
        Date nowWithoutMinutes = truncateDate(nowOriginal, ChronoUnit.MINUTES);
        System.out.printf("nowOriginal = %s, nowWithoutMinutes = %s%n", nowOriginal, nowWithoutMinutes);
        System.out.printf("nowOriginal = %d, nowWithoutMinutes = %d%n", nowOriginal.getTime(), nowWithoutMinutes.getTime());
        System.out.println("<==test2");
    }

    private static Date truncateDate(final Date original, final ChronoUnit unit) {
        return new Date(java.sql.Timestamp.valueOf(
                (new java.sql.Timestamp(original.getTime()))
                        .toLocalDateTime()
                        .truncatedTo(unit))
                .getTime()
        );
    }
}
