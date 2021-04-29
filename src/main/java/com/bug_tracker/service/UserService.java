package com.bug_tracker.service;

import com.bug_tracker.dto.UserDTO;
import com.bug_tracker.model.Bug;
import com.bug_tracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private  RestTemplate restTemplate;
    private  BCryptPasswordEncoder bCryptPasswordEncoder;//= new BCryptPasswordEncoder(10, new SecureRandom());

    public UserService() {
    }

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public UserService(UserRepository userRepository, RestTemplate restTemplate, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Bug[] getBugs(String userEmail){
        String url = "http://localhost:8080/bugs?email="+userEmail;
        ResponseEntity<Bug[]> response = this.restTemplate.getForEntity(url, Bug[].class);
        if(response.getStatusCode() == HttpStatus.OK)
            return response.getBody();
        else
            return null;
    }

    public void addUser(UserDTO userDTO)
    {
        //_____Encryption of Password_____
        String encodedPassword = bCryptPasswordEncoder.encode(userDTO.getPassword());
        //assertTrue(encoder.matches("myPassword", result));
//        assertTrue(bCryptPasswordEncoder.matches(userDTO.getPassword(),encodedPassword));
        //_________________________________

        User user = new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail(),
              encodedPassword, userDTO.getProfilePicture(), null, null,
             new Date(),null);
        userRepository.save(user);
    }

    public Optional<UserDTO> getUserById(Integer id)
    {
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent())
            return Optional.ofNullable(new UserDTO());
        return Optional.of(new UserDTO(optionalUser.get()));
    }

    public Optional<UserDTO> getUserByEmail(String email){
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(!optionalUser.isPresent())
            return Optional.ofNullable(new UserDTO());
        return Optional.of(new UserDTO(optionalUser.get()));
    }

}
