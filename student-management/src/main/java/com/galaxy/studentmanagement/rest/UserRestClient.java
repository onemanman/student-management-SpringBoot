package com.galaxy.studentmanagement.rest;

import com.galaxy.studentmanagement.model.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class UserRestClient {
    public List<User> getUserRestData(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<User>> response =
                restTemplate.exchange
                        (
                          "http://localhost:8888/getData",
                              HttpMethod.GET,
                             null,
                              new ParameterizedTypeReference<>(){}
                        );
        return response.getBody();
    }

    public User createUserRestData(User newUser){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange
                        (
                        "http://localhost:8888/getData",
                            HttpMethod.POST,
                            new HttpEntity<>(newUser),
                            User.class
                        )
                        .getBody();
    }

}
