package com.itmuch.cloud.feign;

import com.itmuch.cloud.entity.User;
import com.itmuch.config.Configuration1;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "microservice-peovider-user",configuration = Configuration1.class)
public interface UserFeignClient {

    //@RequestMapping(value = "/simple/{id}",method = RequestMethod.GET)
    @RequestLine("GET /simple/{id}")
    User findById(@Param("id") Long id);
}
