package com.stulsoft.pjava.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yuriy Stul
 */
public class Permutation {
    public static void main(String args[]) {
        System.out.println("==>main");

        List<List<Integer>> perms = buildPermutations(Arrays.asList(1, 2, 3));
        perms.forEach(perm ->
                System.out.println(String.join(", ", perm.stream().map(Object::toString).collect(Collectors.toList())))
        );

        System.out.println("<==main");
    }

    private static <T> List<List<T>> buildPermutations(List<T> src) {
        if (src.isEmpty())
            return new ArrayList<>();
        else if (src.size() == 1) {
            List<List<T>> list = new ArrayList<>();
            list.add(src);
            return list;
        } else {
            List<List<T>> result = new ArrayList<>();
            for (int i = 0; i < src.size(); ++i) {
                Tuple2<List<T>> beforeAndRest = CollectionSplitter.splitAt(src, i);
                List<T> before = beforeAndRest.getLeft();
                List<T> rest = beforeAndRest.getRight();
                Tuple2<List<T>> elementAndRest = CollectionSplitter.splitAt(rest, 1);
                T element = elementAndRest.getLeft().get(0);
                before.addAll(elementAndRest.getRight());
                List<List<T>> subPermutations = buildPermutations(before);
                List<List<T>> list = subPermutations.stream().map(s -> {
                    List<T> l = new ArrayList<>();
                    l.add(element);
                    l.addAll(s);
                    return l;
                }).collect(Collectors.toList());
                result.addAll(list);
            }
            return result;
        }
    }
}
