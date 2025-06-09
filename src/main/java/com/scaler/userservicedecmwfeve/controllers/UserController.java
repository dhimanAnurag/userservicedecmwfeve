package com.scaler.userservicedecmwfeve.controllers;

import com.scaler.userservicedecmwfeve.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    public User login() {
        // check if email and password in db
        // if yes return user
        // else throw some error
        return null;
    }

    public User signUp() {
        // no need to hash the password for now
        // just store the password as it is
        // for now no need to have email  verifiation
        return null;
    }

    public ResponseEntity<Void> logout() {
        // delete token if exists -> 200
        // if it doesn't exist return the 404
        return null;
    }
}
