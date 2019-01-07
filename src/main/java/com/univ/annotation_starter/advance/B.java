package com.univ.annotation_starter.advance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * author univ
 * date 2018/12/2 10:20 AM
 * description 普通的类
 */
@Component  // 此时能被自动扫描到
public class B {
    private String name = "b-name";

    // 自动注入
    @Autowired
    private A a;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}
