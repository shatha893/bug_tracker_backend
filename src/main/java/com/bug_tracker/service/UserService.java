package com.bug_tracker.service;

import com.bug_tracker.dto.UserDTO;
import com.bug_tracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.security.SecureRandom;
import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(UserDTO userDTO)
    {
        int strength = 10;
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        String encodedPassword = bCryptPasswordEncoder.encode(userDTO.getPassword());
        User user = new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail(), encodedPassword, userDTO.getProfilePicture(),null,null,new Date(),null);
        userRepository.save(user);
    }
}
