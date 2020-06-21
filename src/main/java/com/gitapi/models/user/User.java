package com.gitapi.models.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("login")
    private String username;

    @JsonProperty("type")
    private String userType;    

    @JsonProperty("avatar_url")
    private String avatarImage;

    @JsonProperty("html_url")
    private String profileUrl;
    
    @JsonProperty("url")
    private String userInfoUrl;

    private UserInfo userInfo;

    public String getUserInfoUrl() {
        return this.userInfoUrl;
    }

    public void setUserInfoUrl(String userInfoUrl) {
        this.userInfoUrl = userInfoUrl;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public User() {
    }

    public User(String username, String userType, String avatarImage, String profileUrl) {
        this.username = username;
        this.userType = userType;
        this.avatarImage = avatarImage;
        this.profileUrl = profileUrl;
    }

    public String getUsername() {
        return this.username;
    }

    public String getUserType() {
        return this.userType;
    }

    public String getAvatarImage() {
        return this.avatarImage;
    }

    public String getProfileUrl() {
        return this.profileUrl;
    }
}