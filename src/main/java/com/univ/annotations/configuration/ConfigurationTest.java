package com.univ.annotations.configuration;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author univ
 * @datetime 2019/1/7 11:54 AM
 * @description 使用@Import引入其它被@Configuration注解的类，此时便可以按照实际需要使用多个@Configuration注解了
 */
@Configuration
@Import({ServiceConfiguration.class, DaoConfiguration.class})
public class ConfigurationTest {

    @Test
    public void multiConfiguration() {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationTest.class);
        ConfigurationTest configurationTest = (ConfigurationTest) applicationContext.getBean("configurationTest");
        System.out.println(configurationTest);

        ServiceDemo serviceDemo = applicationContext.getBean(ServiceDemo.class);
        ServiceDemo serviceDemo2 = (ServiceDemo) applicationContext.getBean("getService");
        System.out.println(serviceDemo);
        System.out.println(serviceDemo2);

        DaoDemo daoDemo = (DaoDemo) applicationContext.getBean("getDaoDemo");
        DaoDemo daoDemo2 = applicationContext.getBean(DaoDemo.class);
        System.out.println(daoDemo);
        System.out.println(daoDemo2);
    }
}
