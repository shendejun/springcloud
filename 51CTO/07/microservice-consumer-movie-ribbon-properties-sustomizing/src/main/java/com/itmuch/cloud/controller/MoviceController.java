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
        //这里的负载均衡方式使用的是配置文件中的额 NFLoadBalancerRuleClassName
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-peovider-user");
        System.out.println("user.NFLoadBalancerRuleClassName -> "+serviceInstance.getHost()+":"+serviceInstance.getPort()+":"+serviceInstance.getServiceId());
        
        //VIP 虚拟ip
        return this.restTemplate.getForObject("http://microservice-peovider-user/hi",String.class);
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
