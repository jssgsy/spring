package com.univ.event.annotation;

import org.springframework.context.ApplicationEvent;

/**
 * @author univ
 * @date 2019/1/29 9:33 AM
 * @description 定义一个事件：注册事件
 *
 * 定义事件需要继承spring提供的ApplicationEvent
 */
public class RegisterEvent extends ApplicationEvent {

    /**
     * 注意
     *  1. 基类ApplicationEvent并没有默认的构造函数，这就要求自定义的事件子类必须提供显示的构造函数，用来提供source参数(查看基类源码)
     *  2. 这里的构造函数是自定义的，source的类型可以自定义
     *
     *
     * @param source the component that published the event (never {@code null})
     */
    public RegisterEvent(String source) {
        super(source);
    }
}
