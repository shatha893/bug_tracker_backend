package com.bug_tracker.api;

import com.bug_tracker.dto.UserDTO;
import com.bug_tracker.errorHandling.ApiResponse;
import com.bug_tracker.model.Bug;
import com.bug_tracker.service.UserService;
import io.netty.handler.codec.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/userRegistration")
    public ResponseEntity<ApiResponse> addUser(@Valid @RequestBody UserDTO user)
    {
        userService.addUser(user);

        return new ResponseEntity<ApiResponse>(new ApiResponse(HttpStatus.OK,"Success"), HttpStatus.OK);
    }

    public ResponseEntity<ApiResponse> listUserBugs(UserDTO userDTO){
        Bug[] userBugs = userService.getBugs(userDTO.getEmail());
        if(userBugs == null)
            return new ResponseEntity<ApiResponse>(new ApiResponse(HttpStatus.OK,"No bugs for this user"),HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(new ApiResponse(HttpStatus.OK,"Success"),HttpStatus.OK);
    }

}
