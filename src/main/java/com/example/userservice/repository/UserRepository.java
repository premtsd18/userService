package com.example.userservice.repository;

import com.example.userservice.models.User;
import com.example.userservice.repository.projections.UserProjection;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User getUserById(Long id);

    public List<UserProjection> getAllBy();

//    @Query("select u from User u where u.id=:id")
//    public UserProjection something(Long id);


    @Transactional
    public void deleteUserById(Long id);
    public User save(User user);

}