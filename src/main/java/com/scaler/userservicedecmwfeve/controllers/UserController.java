package com.scaler.userservicedecmwfeve.controllers;

import com.scaler.userservicedecmwfeve.exceptions.UserNotExistsException;
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

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") long id) throws UserNotExistsException {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<Users> deleteUserById(@PathVariable("id") long id) throws UserNotExistsException {
        return new ResponseEntity<>(userService.deleteUserById(id), HttpStatus.OK);
   }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUserById(@PathVariable("id") long id, @RequestBody Users users) throws UserNotExistsException {
        return new ResponseEntity<>(userService.updateUserById(id,users), HttpStatus.OK);
    }
}
