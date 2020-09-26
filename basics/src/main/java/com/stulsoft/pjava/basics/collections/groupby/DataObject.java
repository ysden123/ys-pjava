/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.basics.collections.groupby;

import java.util.Objects;

/**
 * @author Yuriy Stul
 */
public class DataObject {
    private final String name;
    private final Integer age;

    public DataObject(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataObject)) return false;
        DataObject that = (DataObject) o;
        return getName().equals(that.getName()) &&
                getAge().equals(that.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    public String toString() {
        return "DataObject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
