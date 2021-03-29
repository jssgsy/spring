package com.univ.event.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author univ
 * @date 2019/1/29 9:37 AM
 * @description 用户服务
 *
 * 注意
 *  有了ApplicationEventPublisher实例便有了事件发布的能力
 */
@Service
public class UserServiceImpl implements UserService{

    /**
     * 事件是通过此对象发出的
     * 注：
     *  1. 有了ApplicationEventPublisher便拥有了事件发布能力；
     *  2. ApplicationEventPublisher自动被注入到容器中，采用Autowired即可获取。
     */
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void register(String name) {
        System.out.println(name + " 被注册了。");
        applicationEventPublisher.publishEvent(new RegisterEvent(name));
    }

}
