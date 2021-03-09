package com.bug_tracker.api;

import com.bug_tracker.dto.UserDTO;
import com.bug_tracker.errorHandling.ApiError;
import com.bug_tracker.errorHandling.RestExceptionHandler;
import com.bug_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.xml.ws.Response;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/userRegistration")
    public RestExceptionHandler addUser(@Valid @RequestBody UserDTO user)
    {
        userService.addUser(user);
        return new RestExceptionHandler();
    }

}
