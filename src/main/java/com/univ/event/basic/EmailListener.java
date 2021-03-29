package com.univ.event.basic;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author univ
 * @date 2019/1/29 9:42 AM
 * @description
 *
 * 注意：
 *  1. 这里实现了ApplicationListener接口，且提供了RegisterEvent作为泛型参数，表示：此service有了订阅能力，且订阅的事件是RegisterEvent;
 *  2. 实现了ApplicationListener便有了订阅的能力，但此前提是此service需要在容器中存在实例(如这里使用的@Service)
 */
@Service
public class EmailListener implements ApplicationListener<EmailEvent>{

    /**
     * 当订阅的事件发生时需要采取的动作
     * @param event
     */
    // @Async  // 使此事件为异步事件
    public void onApplicationEvent(EmailEvent event) {
        System.out.println("EmailListenerServiceImpl监听到事件了 当前线程：" + Thread.currentThread().getName());

    }
}
