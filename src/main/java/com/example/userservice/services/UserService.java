package com.example.userservice.services;

import com.example.userservice.models.User;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User getUser(Long id);
    public List<User> getAllUser();
    public User createUser(User user);

    public User updateUser(Long id,User user);

    public User modifyUser(Long id,User user);


    public void deleteUser(Long id);

    public String  userLogin(String userName,String password);
}
