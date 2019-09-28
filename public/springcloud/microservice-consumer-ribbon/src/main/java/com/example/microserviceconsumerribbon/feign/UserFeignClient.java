package com.example.microserviceconsumerribbon.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "eureka-client")
public interface UserFeignClient {
    @RequestMapping(method = RequestMethod.GET,value = "/hi")
    String sayHi();
}
