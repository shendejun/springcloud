package com.itmuch.cloud.feign;

import com.itmuch.cloud.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("microservice-peovider-user")
public interface UserFeignClient {

    /**
     * 两个坑：1、@GetMapper不支持；2、@PathVariable的设置value
     */
    @RequestMapping(value = "/simple/{id}",method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);

    /**
     * 这是第三个坑：请求不成功，只要参数是复杂对象，即使指定了是get方法，feign依然会以POST方法进行发送请求。
     */
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    User postUser(@RequestBody User user);

}
