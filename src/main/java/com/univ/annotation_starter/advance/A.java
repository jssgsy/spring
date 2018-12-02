package com.univ.annotation_starter.advance;

import org.springframework.stereotype.Component;

/**
 * @author univ
 * @datetime 2018/12/2 10:16 AM
 * @description 普通的类
 */
@Component  // 此时能被自动扫描到
public class A {
    private String name = "a-name";

    public String getName() {
        return name;
    }

}
