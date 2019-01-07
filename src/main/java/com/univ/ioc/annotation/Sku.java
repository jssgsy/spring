package com.univ.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * author univ
 * date 2018/11/20 10:37 AM
 * description
 */

/*
直接使用@Component注解，表示不用在xml配置文件中使用bean进行显示的配置了，简化配置，当然此时要配置<context:component-scan base-package="com.univ.ioc.annotation"/>
 */
@Component
public class Sku {
    /*
    使用了@Value，@Autowired，@Inject表示不用在xml配置文件中使用property进行显示配置了，简化配置，当然此时要配置<context:annotation-config/>
     */

    private String name = "sku_name";
    private int num = 3;
    @Autowired
    private Product product;

    @Override
    public String toString() {
        return "Sku{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", product=" + product +
                '}';
    }
}
