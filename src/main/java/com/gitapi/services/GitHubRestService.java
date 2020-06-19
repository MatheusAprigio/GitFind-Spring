package com.gitapi.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gitapi.models.User;
import com.gitapi.models.UserInfo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GitHubRestService {

    @Value("${api.gitgub.baseUrl}")
    private String baseUrl;

    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper mapper = new ObjectMapper();

    public List<User> getUsers(String username) {
        int userIndex = 0;
        List<User> usersList = new ArrayList<>();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl.concat("/search/users")).queryParam("q",
                username);

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