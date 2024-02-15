package com.example.userservice.repository;

import com.example.userservice.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public interface TokenRepository extends JpaRepository<Token,Long> {
    Token save(Token token);

    Optional<Token> getTokenByValueAndDeleted(String value,Boolean deleted);

    Optional<Token> findByValueAndDeletedFalseAndExpiryAtGreaterThan(String value, Date expiryAt);

}
