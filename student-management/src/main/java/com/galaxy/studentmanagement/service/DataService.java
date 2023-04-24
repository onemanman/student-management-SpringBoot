package com.galaxy.studentmanagement.service;

import com.galaxy.studentmanagement.model.User;

import java.util.List;

public interface DataService {
    public List<User> getUserData();
    public User createUserData(User newUser);
}
