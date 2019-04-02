package com.univ.aop.annotation;

/**
 * 业务类
 */
public class A {

    public void sing(){
        System.out.println("annotation: A.sing()");
        throw new RuntimeException("runtime exception");
    }

}
