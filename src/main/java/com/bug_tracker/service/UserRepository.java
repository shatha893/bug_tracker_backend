package com.bug_tracker.service;

import com.bug_tracker.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> { }
