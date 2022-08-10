package com.stulsoft.pjava.basics.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @author Yuriy Stul
 **/
public class TimeParsing {
    public static void main(String[] args) {
        String timeStr = "2022-07-21T12:05:19Z";
        Date date = Date.from(LocalDateTime.parse(timeStr).toInstant(ZoneOffset.UTC));
        System.out.println(date);
    }
}
