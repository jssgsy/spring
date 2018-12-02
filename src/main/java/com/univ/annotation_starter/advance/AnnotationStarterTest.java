package com.univ.annotation_starter.advance;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author univ
 * @datetime 2018/12/2 10:25 AM
 * @description 以注解配置类加自动扫描的方式启动容器
 */
public class AnnotationStarterTest {

    /*
    自动扫描，注意查看console输出
     */
    @Test
    public void test1() {
        // 以注解配置的方式启动，指定了配置类为StarterApplication
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationStarterApplication.class);

        A a = (A) applicationContext.getBean("a");
        System.out.println(a.getName());

        B b = (B) applicationContext.getBean("b");
        System.out.println(b.getName());
        System.out.println(b.getA().getName());

        C c = (C) applicationContext.getBean("c");
        System.out.println(c.getName());
    }


}
