package services;

import dto.requests.UserRegistrationRequest;
import dto.responses.UserRegistrationResponse;
import org.springframework.stereotype.Service;


public interface UserService {
    UserRegistrationResponse register(UserRegistrationRequest userRegistrationRequest) throws IllegalArgumentException;

}
