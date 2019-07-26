package com.univ.aop.annotation;

/**
 * 业务类
 */
public class A {

    public String sing(boolean interrupted){
        System.out.println("annotation: A.sing()");
        if (interrupted) {
            throw new RuntimeException("抛出异常了");
        }
        return "result of sing";
    }
}
