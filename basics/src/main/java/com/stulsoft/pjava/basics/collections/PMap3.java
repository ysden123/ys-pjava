package com.stulsoft.pjava.basics.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Yuriy Stul
 **/
public class PMap3 {

    public static void main(String[] args) {
        getPartOfMap();
    }
    private static void getPartOfMap() {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 1; i <= 10; ++i) {
            map.put("str " + i, i);
        }
        System.out.println(map);

        Map<String, Integer> map2 = map.entrySet().stream()
                .skip(2)
                .limit(2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(map2);
    }
}
