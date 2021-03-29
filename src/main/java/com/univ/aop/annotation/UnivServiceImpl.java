package com.univ.aop.annotation;

/**
 * 业务类
 */
public class UnivServiceImpl {

    public String sing(boolean needThrowException){
        System.out.println("[目标方法执行了]: A.sing()");
        if (needThrowException) {
            throw new RuntimeException("UnivServiceImpl抛出的异常");
        }
        return "result of sing";
    }
}
