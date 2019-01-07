package com.univ.properties.annotation;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

/**
 * author univ
 * date 2018/12/4 10:10 AM
 * description 注解形式的引用外部属性文件
 */

@Configuration
@ComponentScan(basePackages = {"com.univ.properties.annotation"})
@PropertySource(value = {"classpath:db.properties"})    // 可引入多个属性文件
public class AnnotationPropertiesTest {

    /**
     * 重要！使用@PropertySource加载外部属性文件，则此方法不可少
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    @Test
    public void test() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AnnotationPropertiesTest.class);
        AnnotationPropertyBean annotationPropertyBean = (AnnotationPropertyBean) ac.getBean("annotationPropertyBean");
        System.out.println(annotationPropertyBean);
    }
}

@Component("annotationPropertyBean")
class AnnotationPropertyBean {

    //找不到默认会抛异常
    @Value("${jdbc.user}")
    private String user;

    @Value("${jdbc.password}")
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AnnotationPropertyBean{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}