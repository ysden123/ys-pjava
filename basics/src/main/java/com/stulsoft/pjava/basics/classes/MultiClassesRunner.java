/*
   Created by Yuriy Stul 2018
*/
package com.stulsoft.pjava.basics.classes;

/**
 * @author Yuriy Stul
 * @since 2/27/2018
 */
public class MultiClassesRunner {
    public static void main(String[] args) {
        new MultiClasses().new MClass1().print();
        new MultiClasses().new MClass2().print();
    }
}
