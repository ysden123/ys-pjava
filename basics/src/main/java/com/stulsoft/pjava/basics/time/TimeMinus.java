package com.stulsoft.pjava.basics.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @author Yuriy Stul
 **/
public class TimeMinus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter date time (yyyy-mm-dd HH:mm:ss");
        String startDate = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(startDate, formatter);
        System.out.println("Start date: " + localDateTime);

        System.out.println("Enter number of hours to minus");
        int hours = scanner.nextInt();
        System.out.println("hours: " + hours);

        System.out.println("Result date: " + localDateTime.minusHours(hours));
    }
}
