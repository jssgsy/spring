package com.univ.annotation_starter.basic;

/**
 * @author univ
 * @datetime 2018/12/2 10:40 AM
 * @description 普通的类
 */
public class C {
    private String name = "c-name";

    public String getName() {
        return name;
    }

    public void initC() {
        System.out.println("C的初始化方法initC被调用了");
    }

    public void destroyC() {
        System.out.println("C的初始化方法destroyC被调用了");
    }
}
