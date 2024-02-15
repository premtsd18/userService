package com.example.userservice.repository;

import com.example.userservice.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User save(User user);
    public Optional<User> getUserByEmail(String email);

}