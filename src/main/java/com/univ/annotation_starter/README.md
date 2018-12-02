# spring容器的两种启动方式
## 配置文件applicationContext.xml
在这里定义bean及其依赖。
```xml
ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
ac.getBean("xxx");
```

## 注解方式启动@Configuration,@Bean,@ComponentScan
* 所谓以注解的方式启动spring容器，是说想尽量少一些(甚至消灭)xml配置文件。
* 被@Configuration注解的类就相当于是定义了(替换)applicationContext.xml中的beans元素的定义；
* 被@Bean注解的方法相当于定义了(替换)applicationContext.xml中的bean元素的定义；
* 注解配置类可以结合自动扫描功能(@ComponentScan)一起使用，就像配置文件方式中配置自动扫描一样；

