package com.itmuch.cloud;

import com.itmuch.config.TestConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
//这个名称一定要是尤里卡里面注册的名称
//这个configuration不能和ConsumerMovieRibbonApplication在同一个包下
@RibbonClient(name = "microservice-peovider-user", configuration = TestConfiguration.class)
public class ConsumerMovieRibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMovieRibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
