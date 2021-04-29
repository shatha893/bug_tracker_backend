package com.bug_tracker.dto;

import com.bug_tracker.model.Bug;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter @Getter
public class BugDTO {

    @NotNull
    private String title;
    private Integer id;
    private Integer assignee;
    @NotNull
    private Bug.Status status;
    @NotNull
    private String description;
    @NotNull
    private Bug.Priority priority;
    private Date updateDate;
    private Integer updatedBy;
    private Date creationDate;
    @NotNull
    private Integer createdBy;

    public BugDTO(Bug bug){
        this.id = bug.getId();
        this.title = bug.getTitle();
        this.assignee = bug.getAssignee();
        this.status = bug.getStatus();
        this.description = bug.getDescription();
        this.priority = bug.getPriority();
        this.updatedBy = bug.getUpdatedBy();
        this.createdBy = bug.getCreatedBy();
        this.creationDate = bug.getCreationDate();
        this.createdBy = bug.getCreatedBy();
    }
}
