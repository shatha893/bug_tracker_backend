package com.bug_tracker.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter @Getter
@Table(name = "bug")
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Date updateDate;
    private Integer updatedBy;
    private Date creationDate;
    private Integer createdBy;
    private Status status;
    private Priority priority;
    private Integer assignee;

    public Bug() {
    }

    public Bug(String title, Status status, String description, Priority priority,
               Date updateDate, Integer updatedBy, Date creationDate, Integer createdBy,Integer assignee) {
        this.status = status;
        this.priority = priority;
        this.title = title;
        this.description = description;
        this.updateDate = updateDate;
        this.updatedBy = updatedBy;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.assignee = assignee;
    }

    public enum Status{
        NEW, CLOSED, RESOLVED, INVALID
    }

    public enum Priority{
        LOW, MEDIUM, HIGH, CRITICAL
    }
}
