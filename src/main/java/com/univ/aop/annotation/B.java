package com.univ.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 定义将要织入到目标类中的切面，如日志，事务，安全等。仅仅只是一个普通的类
 * 1. 所有的通知都可以将JoinPoint当为入参，如下面的before方法；一般用来log或debug
 */
@Aspect // 将Audience声明成一个切面，注意，此时Audience还需要在配置文件中配置使这成为一个真正的切面
// @Component  // 如果没有在配置文件中定义此bean,则这里需要使用@Component以补spring扫描到
public class B {

    /**
     * 定义一个切点，方法点就是切点名
     *
     * 重点：能被拦截的类必须是被Spring管理的，比如ArrayList等jar中的类是不能被拦截的
     */
    @Pointcut("execution(* com.univ.aop.annotation.A.sing(..))")
    public void basic_pointcut() {

    }

    /**
     * 注意，basic_pointcut()而不是 basic_pointcut
     */
    @Before("basic_pointcut()")
    public void before(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println("signature: " + signature);
        System.out.println("before... ");
    }

    /**
     * After 是在目标方法“成功”执行后再执行，如果期间抛出了异常，则这里是捕获不到的
     */
    @After("basic_pointcut()")
    public void after() {
        // 放开下面这句观察@AfterThrowing
        // throw new Exception("我抛出了一个异常");
        System.out.println("after... ");
    }

    /**
     * 1. AfterReturning 也是在目标方法“成功”执行后再执行，如果期间抛出了异常，则这里是捕获不到的
     * 2. 相比较于@After，@AfterReturning可以获取到目标方法的执行结果。
     * 3. AfterReturning在After之后执行
     */
    @AfterReturning(value = "basic_pointcut()", returning = "returnValue")
    public void afterReturn(Object returnValue) {
        System.out.println("after returning...");
        System.out.println("目标方法的返回结果为：" + returnValue);
    }

    /**
     * 当目标方法抛出异常时拦截
     */
    @AfterThrowing("basic_pointcut()")
    public void afterThrowing() {
        System.out.println("after throwing...");
    }

    /**
     * 注意：around之前在@Before之前，around之后在@After之后
     * @param joinPoint
     */
    @Around("basic_pointcut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before around ...");

        /*try {
            // 执行目标方法
            joinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("around 捕获到异常了");
        }*/

        // 注意将上面的注释放开执行看下结果
        joinPoint.proceed();
        System.out.println("after around ...");
    }

}
