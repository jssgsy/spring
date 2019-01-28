package com.univ.annotations.conditional;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author univ
 * @date 2019/1/28 3:21 PM
 * @description
 */
@Configuration
public class ConditionTest {

    @Test
    public void test1() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionTest.class);
        DBService dbService = applicationContext.getBean("dbService", DBService.class);

        System.out.println(dbService.getDBName());
    }

    /**
     * 如果MysqlDBCondition匹配上了，则返回MysqlDB实例
     * @return
     */
    @Bean(name = "dbService")
    @Conditional(MysqlDBCondition.class)
    public DBService mysqlDB() {
        return new MysqlDB();
    }

    /**
     * 如果OracleDBCondition匹配上了，则返回OracleDB实例
     * @return
     */
    @Bean(name = "dbService")
    @Conditional(OracleDBCondition.class)
    public DBService oracleDB() {
        return new OracleDB();
    }
}
