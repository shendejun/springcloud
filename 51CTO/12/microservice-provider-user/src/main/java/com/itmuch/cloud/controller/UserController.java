package com.itmuch.cloud.controller;

import com.itmuch.cloud.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
