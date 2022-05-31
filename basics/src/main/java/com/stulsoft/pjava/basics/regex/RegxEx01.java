/*
 * Copyright (c) 2022 StulSoft
 */

package com.stulsoft.pjava.basics.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegxEx01 {
    public static void main(String[] args) {
        test1();
        test2();
    }
    private static void test1(){
        System.out.println("==>test1");
        String text    =
                "This is the text which is to be searched " +
                        "for occurrences of the word 'is'.";

        String regex = "is";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("found: " + count + " : "
                    + matcher.start() + " - " + matcher.end());
        }
    }

    /**
     * Shows all matcches
     */
    private static void test2(){
        System.out.println("==>test2");
        String text    =
                "This is the text which is to be searched " +
                        "for occurrences of the word 'is'.";

        String regex = "is";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()) {
            System.out.println("found: " +matcher.group(0));
        }
    }
}
