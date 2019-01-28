* XxxCondition类表示某个条件，一般用在当满足某个条件(操作系统，是否有某个jar包)时生成不同的bean；
* XxxCondition需要实现spring提供的Condition接口，同时要使用@Component注解修饰，不然spring没法识别；
* @Conditional：Indicates that a component is only eligible for registration when all specified conditions match;
* @Conditional既可以和@Bean搭配使用，也可以和@Configuration搭配使用，只是此时只有当条件满足时其下的所有bean才会尝试创建；
* 如果几个XxxCondition同时满足条件，经验证，会随机取一个；
* spring boot提供的很多常用的XxxCondition；