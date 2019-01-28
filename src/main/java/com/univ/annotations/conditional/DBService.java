package com.univ.annotations.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

/**
 * @author univ
 * @date 2019/1/28 3:02 PM
 * @description
 */
public interface DBService {
    String getDBName();
}

// bean定义
class MysqlDB implements DBService {

    @Override
    public String getDBName() {
        return "this is mysql";
    }
}

/**
 * 定义一个条件Condition，实现spring提供的Condition接口即可
 * 注意，所有Condition肯定要使用@Component修饰，不然spring找不到
 */
@Component
class MysqlDBCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        /*
        注意，这里只是简单的返回true，实际项目中可根据环境等不同作不同的动作
         */
        return true;
    }
}


// bean定义
class OracleDB implements DBService {
    @Override
    public String getDBName() {
        return "this is oracle";
    }
}

/**
 * 定义一个条件Condition，实现spring提供的Condition接口即可
 * 注意，所有Condition肯定要使用@Component修饰，不然spring找不到
 */
@Component
class OracleDBCondition implements Condition {
    /*
    注意，这里只是简单的返回true，实际项目中可根据环境等不同作不同的动作
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 把这里改成true再运行下测试
        return false;
    }
}

