package com.stulsoft.pjava.sqlfilter;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yuriy Stul
 **/
public class QueryBuilder {

    public static String build(List<Filter> filters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < filters.size(); ++i) {
            Filter filter = filters.get(i);
            if (i > 0) {
                stringBuilder.append(String.format(" %s", filter.getOperator()));
            }
            stringBuilder.append(String.format(" %s", filter.getColumnName()));
            stringBuilder.append(String.format(" %s", filter.getCompareOperator()));
            if (filter.getValue() instanceof String) {
                stringBuilder.append(String.format(" '%s'", filter.getValue()));
            } else {
                stringBuilder.append(String.format(" %s", filter.getValue()));
            }
        }

        return stringBuilder.toString();
    }

    public static String build(Filter[] filters) {
        return build(Arrays.asList(filters));
    }
}
