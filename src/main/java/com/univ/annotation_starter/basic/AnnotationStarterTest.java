package com.univ.annotation_starter.basic;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author univ
 * @datetime 2018/12/2 10:25 AM
 * @description 以注解配置类的方式启动容器
 */
public class AnnotationStarterTest {

    /*
    启动容器，注意查看console输出
     */
    @Test
    public void test1() {
        // 以注解配置的方式启动，指定了配置类为StarterApplication
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationStarterApplication.class);

        // 以xml配置文件的方式启动,指定配置文件为applicationContext.xml
        // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    /*
    从容器中获取bean
     */
    @Test
    public void test2() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationStarterApplication.class);
        A a = (A) applicationContext.getBean("getAInstance");
        System.out.println(a.getName());

        B b = (B) applicationContext.getBean("getBInstance");
        System.out.println(b.getA().getName());
        System.out.println(b.getName());
    }

    /*
    稍微进阶
     */
    @Test
    public void test3() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationStarterApplication.class);
        // 配置类中指定了bean id为c
        C c = (C) applicationContext.getBean("c");
        System.out.println(c.getName());
    }
}
