package com.univ.aop.annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 定义将要织入到目标类中的切面，如日志，事务，安全等。仅仅只是一个普通的类
 */
@Aspect // 将Audience声明成一个切面，注意，此时Audience还需要在配置文件中配置使这成为一个真正的切面
public class B {

    // 定义一个切点，方法点就是切点名
    @Pointcut("execution(* com.univ.aop.annotation.A.sing(..))")
    public void perform() {

    }

    // 前置通知，注意，值是perform()而不是perform
    @Before("perform()")
    public void beforeSing(){
        System.out.println("annotation:唱歌之前");
    }

    @After("perform()")
    public void afterSing() throws Exception {
        // 放开下面这句观察@AfterThrowing
        // throw new Exception("我抛出了一个异常");
        System.out.println("annotation:唱歌之后");
    }
    
    @AfterThrowing("perform()")
    public void afterException() {
        System.out.println("annotation 执行过程中抛异常了");
    }
}
