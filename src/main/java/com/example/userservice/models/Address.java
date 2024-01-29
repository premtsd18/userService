package com.example.userservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address {
    @Id
    @GeneratedValue
    long id;
    String city;
    String street;
    int number;
    String zipcode;
    String latitude;
    String longitude;

}
