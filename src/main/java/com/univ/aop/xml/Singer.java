package com.univ.aop.xml;

/**
 * Univ
 * 16/12/28 16:19
 */

/**
 * 定义aop中被代理的类，即负责真正的业务逻辑处理类，如service层的类
 *
 * 1. Spring的aop中，目标类Singer是否和JDK中的动态代理一样需要实现接口才能被代理?
 *  答：经实验验证，不需要
 */
public class Singer {

    public void sing(){
        System.out.println("A.sing()");
    }

}
