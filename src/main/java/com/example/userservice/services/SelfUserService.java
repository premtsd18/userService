package com.example.userservice.services;

import com.example.userservice.models.Token;
import com.example.userservice.models.User;
import com.example.userservice.repository.TokenRepository;
import com.example.userservice.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class SelfUserService implements UserService{
    private UserRepository userRepository;
    private TokenRepository tokenRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;
    SelfUserService(UserRepository userRepository,TokenRepository tokenRepository,BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository=userRepository;
        this.tokenRepository=tokenRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }

    @Override
    public User SignupUser(String name, String email, String password) {
        User user=new User();
        user.setName(name);
        user.setEmail(email);
        user.setHashedPassword(bCryptPasswordEncoder.encode(password));
        return userRepository.save(user);
    }

    @Override
    public Token LoginUser(String email, String password) {
        Optional<User> userOptional=userRepository.getUserByEmail(email);
        if(userOptional.isEmpty()) return new Token();
        User user=userOptional.get();
        if(!bCryptPasswordEncoder.matches(password,user.getHashedPassword())) return new Token();
        Token token= new Token();
        token.setUser(user);
        token.setExpiryAt(new Date());
        token.setValue(RandomStringUtils.randomAlphanumeric(15));
        return tokenRepository.save(token);
    }


    @Override
    public void logout(String token) {
        Optional<Token> tokenOptional=tokenRepository.getTokenByValueAndDeleted(token,false);
        if(tokenOptional.isEmpty()){
            return;
        }
        Token tokenToUpdate=tokenOptional.get();
        tokenToUpdate.setDeleted(true);
        tokenRepository.save(tokenToUpdate);
    }


}
