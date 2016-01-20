package com.univ.junit;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
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
    
    /**
     * 测试spring的Resource
     * Resource有很多种实现,其实例创建一般有两种方法，一种用构造函数，一种如下所示：
	 * 	   Resource resource = ac.getResource("classpath:applicationContext.xml");
	 *     System.out.println(resource.getDescription());
	 *     //输出：class path resource [applicationContext.xml]
	 *     此时获得的Resource实例类型由调用的application context决定。
	 * Resource可以直接被注入给bean，需要注意的是注入的是一个表示资源的String
     */
    @Test
    public void resource(){
    	/**
    	 * ClassPathResource,即使log4j.properties不存在也不会报错，只是此时exists等方法返回false而已,所以使用之前先判断是否存在
    	 */
    	//如果类路径下有test文件夹，其下有blaba.txt，则读取方法如下；
    	//ClassPathResource resource1 = new ClassPathResource("test/blaba.txt");
    	
    	ClassPathResource classpath = new ClassPathResource("log4j.properties");    
    	System.out.println(classpath.getFilename());
    	System.out.println(classpath.getDescription());
    	System.out.println(classpath.exists());
    	System.out.println(classpath.isOpen());
    	System.out.println(classpath.isReadable());
    	System.out.println("---------------------------------------------");
    	/**
    	 * FileSystemResource,即使test.txt不存在也不会报错，只是此时exists等方法返回false而已,所以使用之前先判断是否存在
    	 */
    	FileSystemResource fileSys = new FileSystemResource("c:\\test.txt");
    	System.out.println(fileSys.getFilename());
    	System.out.println(fileSys.getFilename());
    	System.out.println(fileSys.getDescription());
    	System.out.println(fileSys.exists());
    	System.out.println(fileSys.isOpen());
    	System.out.println(fileSys.isReadable());
    	
    }
    
}

