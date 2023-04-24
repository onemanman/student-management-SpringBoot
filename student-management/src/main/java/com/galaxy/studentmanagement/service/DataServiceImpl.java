package com.galaxy.studentmanagement.service;

import com.galaxy.studentmanagement.model.User;
import com.galaxy.studentmanagement.rest.UserRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {
    @Autowired
    UserRestClient userRestClient;

    @Override
    public List<User> getUserData() {
        return userRestClient.getUserRestData();
    }

    @Override
    public User createUserData(User newUser) {
        return userRestClient.createUserRestData(newUser);
    }
}
