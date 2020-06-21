package com.gitapi.models.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class License {
   
    @JsonProperty("key")
    private String key;
   
    @JsonProperty("name")
    private String name;


    public License() {
    }

    public License(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public License key(String key) {
        this.key = key;
        return this;
    }

    public License name(String name) {
        this.name = name;
        return this;
    }
}