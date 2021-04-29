package com.bug_tracker.service;

import com.bug_tracker.dto.BugDTO;
import com.bug_tracker.dto.UserDTO;
import com.bug_tracker.model.Bug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BugService {

    @Autowired
    private BugRepository bugRepository;

    @Autowired
    private UserService userService;

    public void createBug(BugDTO bugDTO) throws Exception
    {
        Optional<UserDTO> userDTOOptional = userService.getUserById(bugDTO.getCreatedBy());
        if(!userDTOOptional.isPresent())
        {
            throw new Exception("User not found");
        }
        Bug bug = new Bug(bugDTO.getTitle(), bugDTO.getStatus(),bugDTO.getDescription(),
        bugDTO.getPriority(),null,null,new Date(),
                bugDTO.getCreatedBy(),bugDTO.getAssignee());
        bugRepository.save(bug);
    }

    public List<BugDTO> listBugs(String email)
    {
        Optional<UserDTO> userDTOOptional = userService.getUserByEmail(email);
        List<Bug> bugList = bugRepository.findAllByAssignee(userDTOOptional.get().getId());
        List<BugDTO> bugDTOS = new ArrayList<>();
        for(Bug bug:bugList){
            bugDTOS.add(new BugDTO(bug));
        }
        return bugDTOS;
    }

    public void updateBug(BugDTO bugDTO){

    }


}
