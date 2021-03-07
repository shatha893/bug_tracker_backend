package com.bug_tracker.api;

import com.bug_tracker.dto.UserDTO;
import com.bug_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/userRegistration")
    @ResponseStatus(value = HttpStatus.OK)
    public void addUser(@RequestBody UserDTO user)
    {
        userService.addUser(user);
    }
}
