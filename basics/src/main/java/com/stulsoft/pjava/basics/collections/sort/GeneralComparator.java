/*
 * Copyright (c) 2021. Yuriy Stul
 */

package com.stulsoft.pjava.basics.collections.sort;

import java.util.Comparator;

/**
 * @author Yuriy Stul
 */
public class GeneralComparator {
    private GeneralComparator(){}

    public static int compare(Object o1, Object o2){
        if (o1 instanceof Integer || o1 instanceof Long){
            return Long.compare(Long.parseLong(o1.toString()), Long.parseLong(o2.toString()));
        }else{
            return o1.toString().compareTo(o2.toString());
        }
    }
}
