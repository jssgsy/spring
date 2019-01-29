package com.univ.event.basic;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author univ
 * @date 2019/1/29 9:37 AM
 * @description 用户服务
 *
 * 注意
 *  这里实现了spring提供的ApplicationEventPublisherAware，此时此service便有了发布事件的能力，事件的发布需要ApplicationEventPublisher的支持
 */
@Service
public class UserServiceImpl implements UserService, ApplicationEventPublisherAware{

    /**
     * 事件是通过此对象发出的
     */
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void register(String name) {
        System.out.println(name + " 被注册了。");
        applicationEventPublisher.publishEvent(new RegisterEvent(name));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
