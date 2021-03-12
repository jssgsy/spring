package com.univ.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author univ
 * @date 2021/3/12 3:35 下午
 * @description
 */
public class UnivBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("进入到自定义的UnivBeanPostProcessor了，任何初始化之前(postProcessBeforeInitialization), bean: " + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("进入到自定义的UnivBeanPostProcessor，所有初始化之后(postProcessAfterInitialization)， bean: " + bean);
        return bean;
    }
}
