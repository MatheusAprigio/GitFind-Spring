package com.gitapi.controllers;

import com.gitapi.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired
    UserService gitApiService;

    @Value("${api.gitgub.baseUrl}")
    public String baseUrl;

    @GetMapping("/")
    public String getHome() {
        return "index";
    }

    @GetMapping("/users")
    public String getUsers(@RequestParam String username, Model model) {

        model.addAttribute("totalUsers", gitApiService.getUsers(username).size());
        model.addAttribute("users", gitApiService.getUsers(username));
        return "index";
    }

}