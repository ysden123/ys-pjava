package com.stulsoft.pjava.basics.classes.holder;

public class ReqParam implements ClassHolder{
    private final Integer param1;

    public ReqParam(Integer param1) {
        this.param1 = param1;
    }

    public Integer getParam1() {
        return param1;
    }

    @Override
    public String toString() {
        return "ReqParam{" +
                "param1=" + param1 +
                '}';
    }
}
