package com.univ.annotations.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author univ
 * @datetime 2019/1/7 11:52 AM
 * @description
 */
@Configuration
public class ServiceConfiguration {

    @Bean
    public ServiceDemo getService() {
        return new ServiceDemo();
    }
}

class ServiceDemo {

}