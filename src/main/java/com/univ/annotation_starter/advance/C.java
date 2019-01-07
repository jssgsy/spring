package com.univ.annotation_starter.advance;

import org.springframework.stereotype.Component;

/**
 * author univ
 * date 2018/12/2 10:40 AM
 * description 普通的类
 */
@Component  // 此时能被自动扫描到
public class C {
    private String name = "c-name";

    public String getName() {
        return name;
    }

}
