package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class MoviceController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/myHi")
    public String myHi(){
        //VIP 虚拟ip
        String url = "http://microservice-peovider-user/hi";
        System.out.println(url);
        return this.restTemplate.getForObject(url,String.class);
    }

    @GetMapping("/test")
    public String test(){
        //随机
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-peovider-user");
        System.out.println("user1 -> "+serviceInstance.getHost()+":"+serviceInstance.getPort()+":"+serviceInstance.getServiceId());
        //轮询
        ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("microservice-peovider-user2");
        System.out.println("user2 --------------------------------------------------> "+serviceInstance2.getHost()+":"+serviceInstance2.getPort()+":"+serviceInstance2.getServiceId());
        return "1";
    }
}
