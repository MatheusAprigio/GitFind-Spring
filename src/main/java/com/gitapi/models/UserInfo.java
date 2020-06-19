package com.gitapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo {

    @JsonProperty("name")
    private String name;

    @JsonProperty("bio")
    private String bio;


    public UserInfo() {
    }

    public UserInfo(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public UserInfo name(String name) {
        this.name = name;
        return this;
    }

    public UserInfo bio(String bio) {
        this.bio = bio;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", bio='" + getBio() + "'" +
            "}";
    }

}