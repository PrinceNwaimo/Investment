package com.example.services;

import com.example.dto.requests.UserRegistrationRequest;
import com.example.dto.responses.UserRegistrationResponse;


public interface UserService {
    UserRegistrationResponse register(UserRegistrationRequest userRegistrationRequest) throws IllegalArgumentException;

}
