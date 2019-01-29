package com.univ.event.basic;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author univ
 * @date 2019/1/29 9:47 AM
 * @description 积分服务-用户注册下新增积分
 *
 * 注意：
 *  1. 这里实现了ApplicationListener接口，且提供了RegisterEvent作为泛型参数，表示：此service有了订阅能力，且订阅的事件是RegisterEvent
 *  2. 实现了ApplicationListener便有了订阅的能力，但此前提是此service需要在容器中存在实例(如这里使用的@Service)
 */
@Service
public class ScoreServiceImpl implements ScoreService, ApplicationListener<RegisterEvent>{

    @Override
    public void addScore(String name) {
        System.out.println(name + " 积分增加了");
    }

    /**
     * 当订阅的事件发生时需要采取的动作
     * @param event
     */
    @Override
    @Async
    public void onApplicationEvent(RegisterEvent event) {
        System.out.println("ScoreServiceImpl 当前线程：" + Thread.currentThread().getName());
        addScore((String) event.getSource());
    }
}
