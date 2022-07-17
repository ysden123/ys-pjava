package com.stulsoft.pjava.basics.classes.holder;

public class TestClassHolder {
    public static void main(String[] args) {
        test1();
    }

    private static void test1(){
        System.out.println("==>test1");
        Container container = new Container();

        container.add(new ReqParam(1))
                .add(ReqType.TYPE1)
                .add(new ReqParam(2));
        System.out.println(container);
    }
}
