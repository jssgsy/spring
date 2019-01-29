package com.univ.event.annotation;

/**
 * @author univ
 * @date 2019/1/29 9:46 AM
 * @description
 */
public interface ScoreService {

    /**
     * 为某个用户增加积分
     * @param name
     */
    void addScore(String name);
}
