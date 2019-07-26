package com.univ.aop.annotation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationAopTest {

    /**
     * 注意查看运行结果
     */
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        A a = (A) applicationContext.getBean("a_annotation");
        a.sing(false);
    }

    /**
     * 注意查看运行结果
     */
    @Test
    public void test1(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        A a = (A) applicationContext.getBean("a_annotation");
        a.sing(true);
    }


}
