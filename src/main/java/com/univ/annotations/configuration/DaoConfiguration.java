package com.univ.annotations.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author univ
 * @datetime 2019/1/7 11:53 AM
 * @description
 */
@Configuration
public class DaoConfiguration {

    @Bean
    public DaoDemo getDaoDemo() {
        return new DaoDemo();
    }
}

class DaoDemo {

}