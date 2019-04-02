package com.univ.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 定义将要织入到目标类中的切面，如日志，事务，安全等。仅仅只是一个普通的类
 */
@Aspect // 将Audience声明成一个切面，注意，此时Audience还需要在配置文件中配置使这成为一个真正的切面
// @Component  // 如果没有在配置文件中定义此bean,则这里需要使用@Component以补spring扫描到
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

    /**
     * throwing：用来绑定抛出的异常信息
     * @param ex
     *
     * 注：
     * 1. @AfterThrowing可以捕捉到目标切点中的异常，但不能完全处理该异常，抛出的异常依然会传播到上一级调用者，直至传播到JVM，导致程序终止
     * 2. 可以加一个joinPoint参数用来获取切点的相关信息，但只能放在第一个参数处
     */
    @AfterThrowing(pointcut = "perform()", throwing = "ex")
    public void afterException(JoinPoint joinPoint, Throwable ex) {
        System.out.println("joinPoint相关信息：" + joinPoint.getSignature().toString());
        System.out.println("异常信息如下：" + ex.getMessage());
        System.out.println("annotation 执行过程中抛异常了");
    }
}
