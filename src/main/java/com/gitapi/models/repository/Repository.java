package com.gitapi.models.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gitapi.models.user.User;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("html_url")
    private String url;

    @JsonProperty("language")
    private String language;

    @JsonProperty("license")
    private License license;

    @JsonProperty("default_branch")
    private String defaultBranch;

    @JsonProperty("owner")
    private User user;

    public Repository() {
    }

    public Repository(String name, String description, String url, String language, License license, String defaultBranch, User user) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.language = language;
        this.license = license;
        this.defaultBranch = defaultBranch;
        this.user = user;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public License getLicense() {
        return this.license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public String getDefaultBranch() {
        return this.defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Repository name(String name) {
        this.name = name;
        return this;
    }

    public Repository description(String description) {
        this.description = description;
        return this;
    }

    public Repository url(String url) {
        this.url = url;
        return this;
    }

    public Repository language(String language) {
        this.language = language;
        return this;
    }

    public Repository license(License license) {
        this.license = license;
        return this;
    }

    public Repository defaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
        return this;
    }

    public Repository user(User user) {
        this.user = user;
        return this;
    }
}