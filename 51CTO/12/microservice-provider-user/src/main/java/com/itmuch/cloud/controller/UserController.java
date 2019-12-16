package com.itmuch.cloud.controller;

import com.itmuch.cloud.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * 用户
 */
@RestController
public class UserController {

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id){
        User user = new User();
        user.setId(id);
        user.setUsername("admin");
        return user;
    }

    @PostMapping("/user")
    public User postUser(@RequestBody User user){
        user.setBalance(0);
        return user;
    }
}
