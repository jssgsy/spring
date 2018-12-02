package com.univ.aop.annotation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationAopTest {

    /**
     * 注解形式的aop
     */
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        A a = (A) applicationContext.getBean("a_annotation");
        a.sing();
    }

}
