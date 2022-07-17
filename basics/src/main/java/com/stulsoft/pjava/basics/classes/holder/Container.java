package com.stulsoft.pjava.basics.classes.holder;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private final List<ClassHolder> classHolderList = new ArrayList<>();

    public List<ClassHolder> getClassHolderList() {
        return new ArrayList<>(classHolderList);
    }

    public Container add(ClassHolder classHolder){
        classHolderList.add(classHolder);
        return this;
    }

    @Override
    public String toString() {
        return "Container{" +
                "classHolderList=" + classHolderList +
                '}';
    }
}
