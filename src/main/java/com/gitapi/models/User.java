package com.gitapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("login")
    private String username;

    @JsonProperty("type")
    private String userType;    
  
    public User() {
    }

    public User(String username, String userType) {
        this.username = username;
        this.userType = userType;
    }

    public String getUsername() {
        return this.username;
    }

    public String getUserType() {
        return this.userType;
    }

    public User username(String username) {
        this.username = username;
        return this;
    }
}