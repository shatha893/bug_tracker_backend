package com.bug_tracker.service;

import com.bug_tracker.model.Bug;
import com.bug_tracker.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugRepository extends CrudRepository<Bug,Integer> {
    List<Bug> findAllByAssignee(int assignee);

}
