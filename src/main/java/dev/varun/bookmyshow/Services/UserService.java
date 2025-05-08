package dev.varun.bookmyshow.Services;

import dev.varun.bookmyshow.Models.User;
import dev.varun.bookmyshow.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public User signUp(String name,
           String email,
           String password){

        Optional<User> optionalEmail = userRepository.findByEmail(email);
        if(optionalEmail.isPresent()){
            throw new RuntimeException("User with this Email is already Present");
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        userRepository.save(user);
        return user;
    }
}
