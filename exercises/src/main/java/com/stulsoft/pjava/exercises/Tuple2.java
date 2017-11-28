/*
 * Copyright (c) 2017, William Hill Online. All rights reserved
 */
package com.stulsoft.pjava.exercises;

/**
 * @author Yuriy Stul.
 */
public class Tuple2<T> {
    private final T left;
    private final T right;

    Tuple2(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getLeft() {
        return left;
    }

    public T getRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple2)) return false;

        Tuple2<?> tuple2 = (Tuple2<?>) o;

        if (!left.equals(tuple2.left)) return false;

        return right != null ? right.equals(tuple2.right) : tuple2.right == null;
    }

    @Override
    public int hashCode() {
        int result = left.hashCode();
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tuple2{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
