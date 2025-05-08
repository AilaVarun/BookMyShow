package dev.varun.bookmyshow.Controllers;

import dev.varun.bookmyshow.Models.User;
import dev.varun.bookmyshow.Models.enums.ResponseStatus;
import dev.varun.bookmyshow.Services.UserService;
import dev.varun.bookmyshow.dtos.SignUpRequestDTO;
import dev.varun.bookmyshow.dtos.SignUpResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public SignUpResponseDTO signUp(@RequestBody SignUpRequestDTO signUpRequestDTO) {
        User user= userService.signUp(signUpRequestDTO.getUsername(),
                signUpRequestDTO.getEmail(),
                signUpRequestDTO.getPassword());

        SignUpResponseDTO signUpResponseDTO = new SignUpResponseDTO();
        signUpResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        signUpResponseDTO.setUser(user);
        return signUpResponseDTO;
    }
}
