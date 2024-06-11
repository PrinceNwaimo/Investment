package controllers;

import dto.requests.UserRegistrationRequest;
import dto.responses.UserRegistrationResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.UserService;



@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {
    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<UserRegistrationResponse> register(@RequestBody UserRegistrationRequest userRegistrationRequest) throws IllegalArgumentException {
        UserRegistrationResponse userRegistrationResponse = userService.register(userRegistrationRequest);
        return new ResponseEntity<>(userRegistrationResponse, HttpStatus.CREATED);
    }
}