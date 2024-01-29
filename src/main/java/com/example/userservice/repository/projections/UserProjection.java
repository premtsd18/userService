package com.example.userservice.repository.projections;

import com.example.userservice.models.Address;

/**
 * Projection for {@link com.example.userservice.models.User}
 */
public interface UserProjection {
    long getId();

    String getEmail();

    String getUserName();

    String getFirstName();

    String getLastName();

    String getPassword();

    String getPhoneNo();

    Address getAddress();
}