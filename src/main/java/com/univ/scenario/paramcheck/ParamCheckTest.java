package com.univ.scenario.paramcheck;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


import lombok.Data;

/**
 * @author univ
 * @date 2021/3/31 2:51 下午
 * @description
 */
@Configuration
@ComponentScan(basePackages = {"com.univ.scenario"})
/**
 * 使用纯注解的方式开启aop，需要使用此注解
 */
@EnableAspectJAutoProxy
public class ParamCheckTest {

    @Test
    public void withoutException() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ParamCheckTest.class);
        ServiceMock serviceMock = (ServiceMock) applicationContext.getBean("serviceMock");
        Pojo pojo = new Pojo();
        pojo.setName("zhangsan");
        pojo.setAge(18);
        serviceMock.fn(pojo, "");
    }

    @Test
    public void withException() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ParamCheckTest.class);
        ServiceMock serviceMock = (ServiceMock) applicationContext.getBean("serviceMock");
        Pojo pojo = new Pojo();
        pojo.setAge(18);
        serviceMock.fn(pojo, "");
    }

}

@Aspect
@Component
class CheckAspect {

    /**
     * \@annotation 捕获不到修改在参数上的注解
     */
    @Pointcut("@annotation(com.univ.scenario.paramcheck.CheckTag)")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        /**
         * 入参的实例
         */
        Object[] args = joinPoint.getArgs();

        /**
         * 之所以会返回二维数组，是因为
         * 1. 参数可能会有多个；
         * 2. 每个参数可能有多个注解修饰；
         *
         * 注：这里的注解和入参顺序是一一对应的
         */
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < args.length; i++) {
            Annotation[] parameterAnnotation = parameterAnnotations[i];
            for (Annotation annotation : parameterAnnotation) {
                if (annotation.annotationType().equals(ParamCheck.class)) {
                    ParamCheck paramCheck = (ParamCheck) annotation;
                    Object arg = args[i];
                    // 要执行的方法是通过字符串形式指定的，因此要获得Method实例，必定要通过getDeclaredMethod方法
                    boolean success = (Boolean) arg.getClass().getDeclaredMethod(paramCheck.name()).invoke(arg);
                    if (!success) {
                        throw new RuntimeException(paramCheck.msg());
                    }
                }
            }
        }
    }

}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CheckTag {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@interface ParamCheck {
    String name() default "check";
    String msg() default "参数不满足条件";
}

@Data
class Pojo {
    private String name;
    private Integer age;

    /**
     * 检测方法
     * @return
     */
    public boolean check() {
        return !StringUtils.isEmpty(name);
    }
}

/**
 * 模拟service类
 */
@Component
class ServiceMock {

    @CheckTag
    public void fn(@ParamCheck(msg = "请检查入参") Pojo pojo, String str) {
        System.out.println("@ParamCheck DemoPO demoPO被执行了");
    }
}
