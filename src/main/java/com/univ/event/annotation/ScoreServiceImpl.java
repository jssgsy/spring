package com.univ.event.annotation;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author univ
 * @date 2019/1/29 9:47 AM
 * @description 积分服务-用户注册下新增积分
 *
 * 注意：
 *  1. 被@EventListener修饰的方法即是事件订阅方法，方法参数的类型表示事件的类型，
 *  2. @EventListener替换了ApplicationListener；
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    /**
     * 订阅事件的方法
     *
     * 注意：被@EventListener修饰的方法只允许有一个参数
     *
     * @param event 订阅的事件(类型)
     */
    @EventListener
    @Order(10)  // 数值越小则优先级越大
    public void register(RegisterEvent event) {
        System.out.println("ScoreServiceImpl 当前线程：" + Thread.currentThread().getName());
        addScore((String) event.getSource());
    }

    @Override
    public void addScore(String name) {
        System.out.println(name + " 积分增加了");
    }
}
