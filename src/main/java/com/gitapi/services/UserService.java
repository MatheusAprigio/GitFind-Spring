package com.gitapi.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gitapi.models.user.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UserService {

    @Value("${api.gitgub.baseUrl}")
    private String baseUrl;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ObjectMapper mapper;

    public List<User> getUsers(String username, String sortBy, String orderBy) {
        int userIndex = 0;
        List<User> usersList = new ArrayList<>();

        if (username.trim().isEmpty()) {
            return usersList;
        }

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl.concat("/search/users"))
                .queryParam("q", username)
                .queryParam("order", orderBy)
                .queryParam("sort", sortBy);

        HashMap<String, List<User>> response = restTemplate.getForObject(builder.toUriString(),
                new HashMap<>().getClass());
        List<User> responseUsers = response.get("items");

        while (userIndex < responseUsers.size()) {
            usersList.add(mapper.convertValue(responseUsers.get(userIndex), User.class));
            usersList.get(userIndex).setUserInfo(setUserInfo(usersList, userIndex));

            userIndex++;
        }

        return usersList;
    }

    public UserInfo setUserInfo(List<User> usersList, int userIndex) {
        try {

            String userInfoUrl = usersList.get(userIndex).getUserInfoUrl();
            String userInfoJson = restTemplate.getForObject(userInfoUrl, userInfoUrl.getClass());
            UserInfo userInfo = mapper.readValue(userInfoJson, UserInfo.class);
            return userInfo;

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}