package com.univ.annotations;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * author univ
 * date 2018/12/2 8:22 PM
 * description @Primary的作用
 *
 * `@Primary`等价于xml配置文件中bean元素的primary属性，用来当有多个candidate时显示指定注入哪个bean
 */
@Configuration
@ComponentScan(basePackages = {"com.univ.annotations"})
public class PrimaryTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PrimaryTest.class);
        APrimary aPrimary = (APrimary) applicationContext.getBean("aPrimary");
        System.out.println(aPrimary.getAnimal().getName());
    }
}

@Component("aPrimary")  // 显示指定bean id
class APrimary {
    @Autowired  // 默认byType注入
    private Animal animal;

    public Animal getAnimal() {
        return animal;
    }
}

interface Animal {
    String getName();
}

@Component
class Dog implements Animal {
    private String name = "dog-name";

    @Override
    public String getName() {
        return name;
    }
}

/*
1. 如果这里放开@Component，则属性animal就有多个bean可装配了；
2. 此时可结合@Primary指定将cat装配给属性animal
 */
@Component
@Primary    // 表示：如果有多个Animal类型的对象作为candidate，则选择cat进行注入
class Cat implements Animal {
    private String name = "cat-name";

    @Override
    public String getName() {
        return name;
    }
}


