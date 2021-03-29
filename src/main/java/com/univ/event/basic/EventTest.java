package com.univ.event.basic;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author univ
 * @date 2019/1/29 9:48 AM
 * @description
 */
@Configuration
@ComponentScan({"com.univ.event.basic"})
@EnableAsync    // 支持异步调用Enables Spring's asynchronous method execution capability
public class EventTest {

    @Test
    public void test1() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(EventTest.class);
        EmailPublishService emailPublishService = applicationContext.getBean(EmailPublishService.class);

        // 注册的时候发送事件，此时订阅此事件的所有listener都可以收到
        emailPublishService.publish("zhangsan");
    }

}
