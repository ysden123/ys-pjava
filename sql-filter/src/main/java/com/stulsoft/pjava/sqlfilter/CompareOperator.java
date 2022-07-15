package com.stulsoft.pjava.sqlfilter;

/**
 * @author Yuriy Stul
 **/
public enum CompareOperator {
    EQ("="), NOT_EQUAL("!="), LIKE("like");

    public final String value;

    private CompareOperator(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
