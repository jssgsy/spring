# spring aop
* spring aop是方法级别的代理；
* 和定义bean一样也有配置文件的方式和注解的方式
* spring-aspects已经依赖了aspectjweaver，不用重复引入；
* 各种通知执行顺序
    * @Around通知-before部分
    * @Before通知
    * 目标方法
    * @Around通知-after部分
    * @After通知

# 目录说明
* xml
    * 配置文件方式使用aop；
* annotation
    * 注解方式使用aop；
  