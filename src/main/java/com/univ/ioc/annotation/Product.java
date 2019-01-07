package com.univ.ioc.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * author univ
 * date 2018/11/20 10:36 AM
 * description
 */

/*
直接使用@Component注解，表示不用在xml配置文件中使用bean进行显示的配置了，简化配置，当然此时要配置<context:component-scan base-package="com.univ.ioc.annotation"/>
 */
@Component
public class Product {

    /*
    使用了@Value，@Autowired，@Inject表示不用在xml配置文件中使用property进行显示配置了，简化配置，当然此时要配置<context:annotation-config/>
     */

    @Value("product_name")
    private String name;
    @Value("20")
    private int height;
    private int price = 30;

    // 只是为了方便输出调试
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", price=" + price +
                '}';
    }
}
