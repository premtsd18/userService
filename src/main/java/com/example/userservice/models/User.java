package com.example.userservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;


@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    String email;
    String userName;
    String firstName;
    String lastName;
    String password;
    String phoneNo;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Address address;

    User(long id, String email, String userName, String firstName, String lastName, String password, String phoneNo, Address address) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    public User() {

    }
}
