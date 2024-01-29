package com.example.userservice.models;

public class UserBuilder {
    private long id;
    private String email;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNo;
    private Address address;

    public UserBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
        return this;
    }

    public UserBuilder setAddress(Address address) {
        this.address = address;
        return this;
    }

    public User createUser() {
        return new User(id, email, userName, firstName, lastName, password, phoneNo, address);
    }
}