package com.gitapi.models.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo {

    @JsonProperty("name")
    private String name;

    @JsonProperty("bio")
    private String bio;

    @JsonProperty("location")
    private String location;

    @JsonProperty("public_repos")
    private Integer countPublicRepositories;

    @JsonProperty("company")
    private String company; 

    @JsonProperty("followers")
    private Integer followers;

    @JsonProperty("following")
    private Integer following;

    @JsonProperty("blog")
    private String blogUrl;

    @JsonProperty("twitter_username")
    private String twitterUsername;


    public UserInfo() {
    }

    public UserInfo(String name, String bio, String location, Integer countPublicRepositories, String company, Integer followers, Integer following, String blogUrl, String twitterUsername) {
        this.name = name;
        this.bio = bio;
        this.location = location;
        this.countPublicRepositories = countPublicRepositories;
        this.company = company;
        this.followers = followers;
        this.following = following;
        this.blogUrl = blogUrl;
        this.twitterUsername = twitterUsername;
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

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCountPublicRepositories() {
        return this.countPublicRepositories;
    }

    public void setCountPublicRepositories(Integer countPublicRepositories) {
        this.countPublicRepositories = countPublicRepositories;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getFollowers() {
        return this.followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getFollowing() {
        return this.following;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }

    public String getBlogUrl() {
        return this.blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public String getTwitterUsername() {
        return this.twitterUsername;
    }

    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }

    public UserInfo name(String name) {
        this.name = name;
        return this;
    }

    public UserInfo bio(String bio) {
        this.bio = bio;
        return this;
    }

    public UserInfo location(String location) {
        this.location = location;
        return this;
    }

    public UserInfo countPublicRepositories(Integer countPublicRepositories) {
        this.countPublicRepositories = countPublicRepositories;
        return this;
    }

    public UserInfo company(String company) {
        this.company = company;
        return this;
    }

    public UserInfo followers(Integer followers) {
        this.followers = followers;
        return this;
    }

    public UserInfo following(Integer following) {
        this.following = following;
        return this;
    }

    public UserInfo blogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
        return this;
    }

    public UserInfo twitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
        return this;
    }
}