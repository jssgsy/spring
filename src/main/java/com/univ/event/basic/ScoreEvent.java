package com.univ.event.basic;

import org.springframework.context.ApplicationEvent;

/**
 * @author univ
 * @date 2021/3/18 7:31 下午
 * @description
 */
public class ScoreEvent extends ApplicationEvent {

    public ScoreEvent(String source) {
        super(source);
    }
}
