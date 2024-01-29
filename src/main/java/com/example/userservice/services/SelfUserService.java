package com.example.userservice.services;

import com.example.userservice.models.User;
import com.example.userservice.models.UserBuilder;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.repository.projections.UserProjection;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SelfUserService implements UserService {

    UserRepository userRepository;

    SelfUserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User getUser(Long id) {
         User user=userRepository.getUserById(id);
         User userReturn= new UserBuilder().createUser();
         userReturn.setId(user.getId());
         userReturn.setUserName(user.getUserName()+"abc");
         userReturn.setEmail(user.getEmail()+"gmail.com");
         userReturn.setPhoneNo(user.getPhoneNo()+"999");
         userReturn.setAddress(userReturn.getAddress());
        System.out.println(userReturn.getAddress());

         return user;
    }

    @Override
    public List<User> getAllUser() {
        List<UserProjection> users= userRepository.getAllBy();
        System.out.println(users.get(0).getAddress());
        List<User> userReturn=new ArrayList<>();
        userReturn.add(new UserBuilder().createUser());
        userReturn.get(0).setAddress(users.get(0).getAddress());
        return userReturn;
//        return null;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        return userRepository.save(user);
    }

    @Override
    public User modifyUser(Long id, User user) {
       User userToUpdate=userRepository.getUserById(id);
       if(user.getUserName()!=null) userToUpdate.setUserName(user.getUserName());
        if(user.getPassword()!=null) userToUpdate.setPassword(user.getPassword());
        if(user.getAddress()!=null) userToUpdate.setAddress(user.getAddress());
        if(user.getFirstName()!=null) userToUpdate.setFirstName(user.getFirstName());
        if(user.getLastName()!=null) userToUpdate.setLastName(user.getLastName());
        if(user.getEmail()!=null) userToUpdate.setEmail(user.getEmail());
        if(user.getPhoneNo()!=null) userToUpdate.setPhoneNo(user.getPhoneNo());

        return userRepository.save(userToUpdate);
    }

    @Override
    public void deleteUser(Long id) {
        System.out.println("CHECKDELETE");
         userRepository.deleteUserById(id);
         return;
    }

    @Override
    public String userLogin(String userName, String password) {
        return userName+12345678;
    }
}
