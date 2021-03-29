package com.univ.aop.xml;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Univ
 * 16/12/28 16:33
 */
public class AopTest {

    /**
     * 测试aop基础知识
     */
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*
         * 此时返回的singer对象是一个代理对象
         */
        Singer singer = (Singer) applicationContext.getBean("singer");
        singer.sing();
    }

}
