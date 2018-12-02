package com.univ.annotation_starter.advance;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author univ
 * @datetime 2018/12/2 10:16 AM
 * @description 应用配置类
 */

/*
basic包下每个bean还是需要显示的通过@Bean来创建，但和xml配置文件用自动扫描一样，用注解配置类的方式也可以使用自动扫描bean的功能
 */
@Configuration
@ComponentScan(basePackages = {"com.univ.annotation_starter.advance"})  // 自动扫描并注册此包下的类(被@Component及其相关注解)为bean
public class AnnotationStarterApplication {

    // 此时这里就不用各种@Bean了
}
