package com.univ.event.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author univ
 * @date 2019/1/29 9:48 AM
 * @description
 */
@Configuration
@ComponentScan({"com.univ.event.annotation"})
public class EventTest {

    @Test
    public void test1() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(EventTest.class);
        UserService userService = applicationContext.getBean(UserService.class);

        // 注册的时候发送事件，此时订阅此事件的所有listener都可以收到
        userService.register("lisi");
    }

}
