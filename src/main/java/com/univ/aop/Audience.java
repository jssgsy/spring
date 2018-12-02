package com.univ.aop;

/**
 * Univ
 * 16/12/28 16:20
 */

/**
 * 定义将要织入到目标类中的切面，如日志，事务，安全等。仅仅只是一个普通的类
 */
public class Audience {

    /**
     * 切面中的方法是否可以有参数？
     */
    public void beforeSing(){
        System.out.println("Audience.beforeSing()");
    }

    public void afterSing(){
        System.out.println("Audience.afterSing()");
    }
}
