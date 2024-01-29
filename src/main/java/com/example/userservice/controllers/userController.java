package com.example.userservice.controllers;



import com.example.userservice.models.User;
import com.example.userservice.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {

    UserService userService;

    userController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/{id}")
    User getUser(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

    @GetMapping
    List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/login")
    String getUserLogin(@RequestBody User user){
        return userService.userLogin(user.getUserName(),user.getPassword());
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable("id") Long id){


         userService.deleteUser(id);
    }

    @PostMapping
    User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping
    User updateUser(@RequestBody User user){
        return userService.updateUser(user.getId(), user);
    }

    @PatchMapping
    User modifyUser(@RequestBody User user){
        return userService.modifyUser(user.getId(), user);
    }
}
