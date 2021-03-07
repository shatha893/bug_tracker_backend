package com.bug_tracker.service;

import com.bug_tracker.dto.UserDTO;
import com.bug_tracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void addUser(UserDTO userDTO)
    {
        User user = new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getProfilePicture(),null,null,new Date(),null);
        userRepository.save(user);
    }
}
