package com.example.userservice.services;

import com.example.userservice.models.Token;
import com.example.userservice.models.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public User SignupUser(String name,String email,String password);
    public Token LoginUser(String email,String password);
    void logout(String token);
}
