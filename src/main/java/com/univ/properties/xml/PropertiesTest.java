package com.univ.properties.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author univ
 * date 2018/12/4 9:29 AM
 * description 外部属性文件
 */
public class PropertiesTest {

    /**
     * xml配置文件中引用外部属性的形式
     */
    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        PropertyBean propertyBean = (PropertyBean) ac.getBean("propertyBean");
        System.out.println(propertyBean);
    }

}



class PropertyBean {
    /*
   外部属性既可以通过@Value注解获取，也可以通过配置文件中定义bean时获取，这里用后者
     */
    // @Value("${jdbc.user}")
    private String user;

    // @Value("${jdbc.password}")
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
        return "PropertyBean{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}