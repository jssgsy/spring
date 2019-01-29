package com.univ.event.annotation;

/**
 * @author univ
 * @date 2019/1/29 9:42 AM
 * @description
 */
public interface EmailService {

    /**
     * 给某个发送邮件
     * @param name
     */
    void sendEmail(String name);

}
