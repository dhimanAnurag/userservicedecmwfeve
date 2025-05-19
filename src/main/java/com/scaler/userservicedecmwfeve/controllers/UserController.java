package com.scaler.userservicedecmwfeve.controllers;

import com.scaler.userservicedecmwfeve.models.User;
import com.scaler.userservicedecmwfeve.services.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(@Qualifier("mysqlUserService") UserService userService) {
        this.userService = userService;
    }
    @PostMapping()
    public User addNewUser(@RequestBody User user) {
        return userService.addNewProduct(user);
    }

}
