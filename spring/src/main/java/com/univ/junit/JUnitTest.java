package com.univ.junit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    
    @Test
    public void  resourceBundleMessageSourceTest(){
    	 MessageSource resources = new ClassPathXmlApplicationContext("applicationContext.xml");
    	//到messages.properties（见配置文件） 找key等于aaa的值，找到则返回，找不到则返回这里的“Default”字符串
         String message = resources.getMessage("aaa", null, "default string to return if not found aaa", null);
         System.out.println(message); 
    }
}

