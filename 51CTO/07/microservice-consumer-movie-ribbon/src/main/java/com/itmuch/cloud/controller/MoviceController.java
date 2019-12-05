package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class MoviceController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/myHi")
    public String myHi(){
        //VIP 虚拟ip
        String url = "http://microservice-peovider-user/hi";
        System.out.println(url);
        return this.restTemplate.getForObject(url,String.class);
    }
}
