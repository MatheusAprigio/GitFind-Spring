package com.gitapi.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gitapi.models.repository.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RepositoryService {
    
    @Value("${api.gitgub.baseUrl}")
    private String baseUrl;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ObjectMapper mapper;

    public List<Repository> getRepositories(String repository, String sortBy, String orderBy) {
        int repositoryIndex = 0;
        List<Repository> repositoryList = new ArrayList<>();

        if (repository.trim().isEmpty()) {
            return repositoryList;
        }

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl.concat("/search/repositories"))
                .queryParam("q", repository)
                .queryParam("order", orderBy)
                .queryParam("sort", sortBy);

        HashMap<String, List<Repository>> response = restTemplate.getForObject(builder.toUriString(),
                new HashMap<>().getClass());
        List<Repository> responseUsers = response.get("items");

        while (repositoryIndex < responseUsers.size()) {
            repositoryList.add(mapper.convertValue(responseUsers.get(repositoryIndex), Repository.class));

            repositoryIndex++;
        }

        return repositoryList;
    }
}