package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceSimpleProviderUser2Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceSimpleProviderUser2Application.class, args);
    }

    @RequestMapping("/hi")
    public String sayHi(){
        System.out.println("hi_2");
        return "hi_2";
    }

}
