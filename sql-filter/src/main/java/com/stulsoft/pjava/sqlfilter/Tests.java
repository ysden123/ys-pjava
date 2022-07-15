package com.stulsoft.pjava.sqlfilter;

import java.util.Collections;

/**
 * @author Yuriy Stul
 **/
public class Tests {
    public static void main(String[] args) {
        testEnums();
        testFilter1();
        testFilter2();
    }
    private static void testEnums(){
        System.out.println("==>testEnums");

        System.out.printf("Operator.AND=%s%n", Operator.AND);
        System.out.printf("CompareOperator.EQ=%s%n", CompareOperator.EQ);
        System.out.printf("CompareOperator.EQ=%s%n", CompareOperator.EQ.value);
    }

    private static void testFilter1(){
        System.out.println("==>testFilter1");

        Filter filter = new Filter(Operator.AND, CompareOperator.EQ, "projectId", "1", Collections.emptyList());

        System.out.printf("%s%n", filter);

    }

    private static void testFilter2(){
        System.out.println("==>testFilter2");

        Filter filter1 = new Filter(Operator.AND, CompareOperator.EQ, "projectId", "1", Collections.emptyList());
        Filter filter2 = new Filter(Operator.AND, CompareOperator.EQ, "projectId", "1", Collections.singletonList(filter1));

        System.out.printf("%s%n", filter2);

    }
}
