package com.univ.junit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import com.univ.ioc.Student;

/** 
 * @author univ 
 * @date 2016年1月14日 下午2:42:09 
 * @version v1.0
 * @Description: 
 */
public class JUnitTest {

	/**
     * 演示简单的依赖注入功能
     */
    @Test
    public void diTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) ac.getBean("student");
        System.out.println(student.getName());
        System.out.println(student.getTeacher().getName());
    }
    
    /**
     * 测试spring的MessageSource用法
     * 更常用的方法是将MessageSource注入到需要使用的bean中，例子见参考手册；
     * 关于MessageSource更多参考配置文件中bean的定义；
     * key的搜索顺序是配置文件中定义的顺序，一找到则返回；
     */
    @Test
    public void  resourceBundleMessageSourceTest(){
    	 MessageSource resources = new ClassPathXmlApplicationContext("applicationContext.xml");
    	//到messages.properties（见配置文件） 找key等于key1的值
    	 String key1 = resources.getMessage("key1", null,"no default value for key1",null);
    	 System.out.println("key1: " + key1);
    	 
    	 //传参，如果配置文件中的形参多余这里的实参，则形参将被解析成字符串
         String key2 = resources.getMessage("key2", new String[]{"liu","univ"}, "default string to return if not found aaa", null);
         System.out.println("key2: " + key2); 
         
         //找不到则返回这里的默认字符串
         String key3 = resources.getMessage("key3", null, "这是没有找到key3所返回的值", null);
         System.out.println("key3: " + key3); 
    }
}

