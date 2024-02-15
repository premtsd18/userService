package com.example.userservice.controllers;



import com.example.userservice.dtos.LoginRequestDTO;
import com.example.userservice.dtos.LogoutRequestDTO;
import com.example.userservice.dtos.SignUpRequestDTO;
import com.example.userservice.models.Token;
import com.example.userservice.models.User;
import com.example.userservice.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {

    UserService userService;

    userController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/signup")
    public User signUp(@RequestBody SignUpRequestDTO request) {
        // no need to hash password for now
        // just store user as is in the db
        // for now no need to have email verification either
        String email = request.getEmail();
        String password = request.getPassword();
        String name = request.getName();
        return (userService.SignupUser(name, email, password));
    }
    @PostMapping("/login")
    public Token login(@RequestBody LoginRequestDTO loginRequest){
        String email=loginRequest.getEmail();
        String password=loginRequest.getPassword();
        return userService.LoginUser(email,password);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> LogoutUser(@RequestBody LogoutRequestDTO request) {
        userService.logout(request.getToken());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
