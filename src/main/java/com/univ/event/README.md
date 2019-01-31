# spring的事件机制
> ApplicationContext通过ApplicationEvent类和ApplicationListener接口进行事件处理。 如果将实现ApplicationListener接口的bean注入到上下文中，则每次使用ApplicationContext发布ApplicationEvent时，都会通知该bean。 本质上，这是标准的观察者设计模式。

# 作用
`解耦`。如代码中将注册与邮件、积分服务解耦了。这也是事件驱动的最大特性之一，如果需要在用户注册时完成其他操作，只需要再添加相应的事件订阅者即可。

# [网络资料](http://www.importnew.com/26782.html)

# 核心概念(类)
* `事件`：继承`ApplicationEvent`便成为了一个事件；
* `事件发布者`：实现`ApplicationEventPublisherAware`接口便有了事件发布能力，需要显示的借助`ApplicationEventPublisher`来发布，实现ApplicationEventPublisherAware是为了提供ApplicationEventPublisher实例；
* `事件订阅者`：实现`ApplicationListener`r<E extends ApplicationEvent>便有了事件订阅能力，且通过泛型表明了其感兴趣的事件类型；

# 说明
* 各个订阅者之间接收到事件没有前后相关的顺序；

## 事件异步化
经验证，各个事件订阅者之间使用的都是同一个线程，说明是同步的，要使事件调用成为异步的也很简单，借助调度系统的@EnableAsync与@Async即可：
* `@EnableAsync`：开启异步调用(任务或者事件)；
* `@Async`：使用某个调用(任务或者事件)成为异步的
注：因为spring默认是使用jdk的动态代理的，即所有代理的方法必须放在接口中，所以在annotation实现事件机制时，要在相应的service接口中对订阅事件的方法进行声明；

# 注解形式的事件
spring从4.2以后的版本支持了注解形式的事件。

## 核心
* 事件发布者：直接获取ApplicationEventPublisher实例来发布事件代替实现ApplicationEventPublisherAware接口；
* 事件订阅者：使用@EventListener修饰方法替换实现ApplicationListener接口

## 顺序
在订阅方法上新增@Order注解即可，数值越小，优先级越大




