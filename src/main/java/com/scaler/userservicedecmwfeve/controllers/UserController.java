package com.scaler.userservicedecmwfeve.controllers;

import com.scaler.userservicedecmwfeve.models.Users;
import com.scaler.userservicedecmwfeve.services.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;


    public UserController(@Qualifier("mysqlUserService") UserService userService) {
        this.userService = userService;
    }
    @PostMapping()
    public Users addNewUser(@RequestBody Users users) {
        return userService.addNewProduct(users);
    }
    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        ResponseEntity<List<Users>> allUsers = new ResponseEntity<>(
                userService.getAllUsers(), HttpStatus.OK
        );
        return allUsers;
    }


}
