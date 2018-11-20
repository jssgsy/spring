# spring 
用maven组织的spring java项目.


# 关于context:annotation-config与context:component-scan

* context:annotation-config：作用是可以使用@Autowired，@Inject等来**省略xml配置文件中的property属性**，简化配置；
* context:component-scan：作用是可以使用@Component，@Controller，@Service等等来**省略xml配置文件中的bean元素**，简化配置
* context:component-scan是context:annotation-config的超集，配置了前者则不需要配置后者；
* 虽然@Controller是告诉spring将此bean当作springmvc的控制器，但其仍然属于spring的范畴，需要配置在spring的配置文件applicationContext.xml中，而不是springmvc的配置文件servletname-servlet.xml中；