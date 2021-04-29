package com.bug_tracker.api;

import com.bug_tracker.dto.BugDTO;
import com.bug_tracker.errorHandling.ApiResponse;
import com.bug_tracker.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Map;

@RestController
public class BugController {

    @Autowired
    private BugService bugService;


    @RequestMapping(method = RequestMethod.POST, value = "/createBug")
    public ResponseEntity<ApiResponse> createBug(@Valid @RequestBody BugDTO bugDTO)
    {
        try{
            bugService.createBug(bugDTO);
        }
        catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND,exception.getMessage()), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK,"Success"), HttpStatus.OK);
    }

    @GetMapping("/")
    public String homepage(Principal principal, Map<String, Object> model){
        model.put("bugList",bugService.listBugs(principal.getName()));
        return "Homepage";
    }

    //I need to get the bug that I want to update and then post the new data
}
