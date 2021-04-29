package com.bug_tracker.api;

import com.bug_tracker.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UpdateBug {

    @Autowired
    BugService bugService;

}
