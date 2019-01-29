package com.univ.event.annotation;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author univ
 * @date 2019/1/29 9:42 AM
 * @description 邮件服务-用户注册后发送邮件
 *
 * 注意：
 *  1. 被@EventListener修饰的方法即是事件订阅方法，方法参数的类型表示事件的类型，
 *  2. @EventListener替换了ApplicationListener；
 */
@Service
public class EmailServiceImpl implements EmailService{

    /**
     * 订阅事件的方法
     *
     * 注意：被@EventListener修饰的方法只允许有一个参数
     *
     * @param event 订阅的事件(类型)
     */
    @EventListener
    public void register(RegisterEvent event) {
        System.out.println("EmailServiceImpl 当前线程：" + Thread.currentThread().getName());
        sendEmail((String) event.getSource());
    }

    public void sendEmail(String name) {
        System.out.println(name + " 收到邮件了");
    }
}
