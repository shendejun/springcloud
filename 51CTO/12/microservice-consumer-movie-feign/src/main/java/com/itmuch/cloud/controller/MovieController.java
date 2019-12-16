package com.itmuch.cloud.controller;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id){
        return this.userFeignClient.findById(id);
    }

    @PostMapping("/user")
    public User testPost(@RequestBody User user){
        return this.userFeignClient.postUser(user);
    }
}