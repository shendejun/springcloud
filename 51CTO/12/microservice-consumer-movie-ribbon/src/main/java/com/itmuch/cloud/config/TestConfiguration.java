package com.itmuch.cloud.config;

import com.itmuch.cloud.ExcludeFromComponentScan;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 参考地址：
 * https://cloud.spring.io/spring-cloud-static/Finchley.SR4/single/spring-cloud.html#_customizing_the_ribbon_client
 */
@Configuration
@ExcludeFromComponentScan
public class TestConfiguration {

//    @Autowired
//    IClientConfig config;

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }

}