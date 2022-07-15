package com.stulsoft.pjava.sqlfilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuriy Stul
 **/
public class Filter {
    private final Operator operator;
    private final CompareOperator compareOperator;
    private final String columnName;
    private final Object value;

    private final List<Filter> filters;

    public Filter(Operator operator, CompareOperator compareOperator, String columnName, Object value,
                  List<Filter> filters) {
        this.operator = operator;
        this.compareOperator = compareOperator;
        this.columnName = columnName;
        this.value = value;
        this.filters = filters;
    }

    public Operator getOperator() {
        return operator;
    }

    public CompareOperator getCompareOperator() {
        return compareOperator;
    }

    public String getColumnName() {
        return columnName;
    }

    public Object getValue() {
        return value;
    }

    public List<Filter> getFilters() {
        return new ArrayList<>(filters);
    }

    @Override
    public String toString() {
        return "Filter{" +
                "operator=" + operator +
                ", compareOperator=" + compareOperator +
                ", columnName=" + columnName +
                ", value=" + value +
                ", filters=" + filters +
                '}';
    }
}
