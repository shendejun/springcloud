package com.example.microserviceprovideruser2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceProviderUser2Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceProviderUser2Application.class, args);
    }

    @RequestMapping("/hi")
    public String sayHi(){
        return "hi_2";
    }

}
