package com.galaxy.studentmanagement.controller;

import com.galaxy.studentmanagement.model.User;
import com.galaxy.studentmanagement.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/getData")
public class DataController {

    public final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping
    public List<User> getUserData () {
        log.info("GET /getData");
        return dataService.getUserData();
    }

    @PostMapping
    public User createUserData(@RequestBody User newUser){
        log.info("POST /getData");
        return dataService.createUserData(newUser);
    }
}
