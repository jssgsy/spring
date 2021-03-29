package com.univ.aop.annotation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationAopTest {

    /**
     * 注意查看运行结果
     * 不抛异常
     */
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UnivServiceImpl univServiceImpl = (UnivServiceImpl) applicationContext.getBean("univServiceImpl");
        univServiceImpl.sing(false);
    }

    /**
     * 注意查看运行结果
     * 抛异常
     */
    @Test
    public void test1(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UnivServiceImpl univServiceImpl = (UnivServiceImpl) applicationContext.getBean("univServiceImpl");
        univServiceImpl.sing(true);
    }


}
