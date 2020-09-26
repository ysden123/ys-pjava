/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.collections.sort;

import java.util.Objects;

/**
 * @author Yuriy Stul
 */
public class DataObject {
    private final String name;
    private final Integer age;
    private final Integer sum;

    public DataObject(String name, Integer age, Integer sum) {
        this.name = name;
        this.age = age;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSum() {
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataObject)) return false;
        DataObject that = (DataObject) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getAge(), that.getAge()) &&
                Objects.equals(getSum(), that.getSum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getSum());
    }

    @Override
    public String toString() {
        return "DataObject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sum=" + sum +
                '}';
    }
}
