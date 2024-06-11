package services;
import data.model.User;
import data.repository.UserRepository;
import dto.requests.UserRegistrationRequest;
import dto.responses.UserRegistrationResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Slf4j
public class UserServicesImp implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public UserRegistrationResponse register(UserRegistrationRequest request) {
        validateInput(request);
        if (userExists(request.getEmail())) {
            throw new IllegalArgumentException(request.getEmail() + " already exists");
        }
        User user = modelMapper.map(request, User.class);
        User savedUser = userRepository.save(user);
        return buildRegisterUserResponse(savedUser);
    }

    private void validateInput(UserRegistrationRequest request) {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }
    }

    private boolean userExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    private UserRegistrationResponse buildRegisterUserResponse(User user) {
        UserRegistrationResponse response = new UserRegistrationResponse();
        response.setMessage("User registered successfully");
        response.setId(user.getUserId());
        return response;
    }
}
