package com.galaxy.studentmanagement.rest;

import com.galaxy.studentmanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public class UserRestClient {

    @Autowired
    private WebClient webClient;

    public List<User> getUserRestData(){
        return webClient.get()
                .uri("http://localhost:8888/getData")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<User>>() {})
                .block();
    }

    public User createUserRestData(User newUser){
        return webClient.post()
                .uri("http://localhost:8888/getData")
                .body(Mono.just(newUser), User.class)
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }

//    public List<User> getUserRestData(){
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<List<User>> response =
//                restTemplate.exchange
//                        (
//                          "http://localhost:8888/getData",
//                              HttpMethod.GET,
//                             null,
//                              new ParameterizedTypeReference<>(){}
//                        );
//        return response.getBody();
//    }

//    public User createUserRestData(User newUser){
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.exchange
//                        (
//                        "http://localhost:8888/getData",
//                            HttpMethod.POST,
//                            new HttpEntity<>(newUser),
//                            User.class
//                        )
//                        .getBody();
//    }

}
