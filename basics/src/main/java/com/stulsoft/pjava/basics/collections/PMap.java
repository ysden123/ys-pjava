/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.pjava.basics.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Playing with map.
 *
 * @author Yuriy Stul
 */
public class PMap {
    /**
     * Usage Map::computeIfAbsent
     */
    private static void computeIfAbsent() {
        System.out.println("==>computeIfAbsent");
        Map<Long, List<String>> theMap = new HashMap<>();

        Long l = 1L;
        List<String> theList = theMap.computeIfAbsent(l, k -> new ArrayList<>());
        System.out.println("(1) theList has " + theList.size() + " items");
        theList.add("s1");
        theList.add("s2");
        theList.add("s3");
        System.out.println("(1.1) theList is: " + String.join(", ", theList));

        theList = theMap.computeIfAbsent(l, k -> new ArrayList<>());
        System.out.println("(2) theList has " + theList.size() + " items");
        theList.add("s1a");
        theList.add("s2a");
        theList.add("s3a");
        System.out.println("(2.1) theList is: " + String.join(", ", theList));

        l = 2L;
        theList = theMap.computeIfAbsent(l, k -> new ArrayList<>());
        System.out.println("(3) theList has " + theList.size() + " items");
        theList.add("s1b");
        theList.add("s2b");
        theList.add("s3b");
        System.out.println("(3.1) theList is: " + String.join(", ", theList));

        System.out.println("<==computeIfAbsent");
    }

    public static void main(String[] args) {
        System.out.println("==>main");
        computeIfAbsent();
        System.out.println("<==main");

    }
}
