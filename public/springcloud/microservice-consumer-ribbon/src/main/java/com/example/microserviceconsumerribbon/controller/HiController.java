package com.example.microserviceconsumerribbon.controller;

import com.example.microserviceconsumerribbon.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class HiController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    UserFeignClient userFeignClient;

    @GetMapping("/myHi")
    public String myHi(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/hi";
        System.out.println(url);
        return this.restTemplate.getForObject(url,String.class);
    }

    @GetMapping("/feign/myHi")
    public String myHi2(){
        return userFeignClient.sayHi();
    }
}
