package com.itmuch.cluod.microservicesimpleconsumermovice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MicroserviceSimpleConsumerMoviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceSimpleConsumerMoviceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    //上面的restTemplate方法就相当于下面这行代码，实例化
    //private RestTemplate restTemplate = new RestTemplate();

}
