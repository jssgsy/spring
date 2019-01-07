package com.univ.annotation_starter.basic;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * author univ
 * date 2018/12/2 10:16 AM
 * description 应用的注解配置类
 */

/*
1. 被@Configuration注解的类就相当于是声明applicationContext.xml文件中的beans元素，可以理解为被@Configuration注解的类就相当于是applicationContext.xml文件
 */
@Configuration
public class AnnotationStarterApplication {

    /*
    1. bean声明：相当于定义了applicationContext.xml文件中的bean元素，
    2. 创建的bean默认是单例，所以这里多次调用getInstance()方法，返回的是同一个实例；
    3. 方法名就是bean id，所以用applicationContext.getBean("getAInstance");
     */
    @Bean
    A getAInstance() {
        return new A();
    }

    /*
    声明bean并引入依赖
     */
    @Bean
    B getBInstance() {
        B b = new B();
        // 注意，这里多次调用返回的是同一个bean，因为默认是单例
        b.setA(getAInstance());
        return b;
    }

    // 查看@Beam的属性，发现其实就是配置文件中bean元素的属性
    @Bean(name = "c", initMethod = "initC", destroyMethod = "destroyC")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) // 默认是单例，可设置为原型
    C getCInstance() {
        return new C();
    }



}
