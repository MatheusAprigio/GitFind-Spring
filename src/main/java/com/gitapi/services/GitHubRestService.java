package com.gitapi.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gitapi.models.User;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GitHubRestService {

    @Value("${api.gitgub.baseUrl}")
    private String baseUrl;

    public List<User> getUsers(String username){
        List<User> usersList = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl.concat("/search/users")).queryParam("q", username);
        
        HashMap<String, List<User>> response = restTemplate.getForObject(builder.toUriString(), new HashMap<>().getClass());
        List<User> responseUsers = response.get("items");

        for(int i = 0; i < responseUsers.size(); i++){
            usersList.add(mapper.convertValue(responseUsers.get(i), User.class));
            System.out.println(usersList.get(i));
        };

       return usersList;
    }
}