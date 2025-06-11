package com.scaler.userservicedecmwfeve.controllers;
import com.scaler.userservicedecmwfeve.dtos.LoginRequestDto;
import com.scaler.userservicedecmwfeve.dtos.LogoutRequestDto;
import com.scaler.userservicedecmwfeve.dtos.SignUpRequestDto;
import com.scaler.userservicedecmwfeve.models.Token;
import com.scaler.userservicedecmwfeve.models.User;
import com.scaler.userservicedecmwfeve.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public Token login(@RequestBody LoginRequestDto request) {
        // check if email and password in db
        // if yes return user
        // else throw some error
        return userService.login(request.getEmail(), request.getPassword());
    }
    @PostMapping("/signup")
    public User signUp(@RequestBody SignUpRequestDto request) {
        // no need to hash the password for now
        // just store the password as it is
        // for now no need to have email  verifiation
        String email = request.getEmail();
        String password = request.getPassword();
        String name = request.getName();

        return userService.signUp(name, email, password);
    }
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto request) {
        // delete token if exists -> 200
        // if doesn't exist give a 404

        userService.logout(request.getToken());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
