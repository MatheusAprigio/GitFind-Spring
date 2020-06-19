package com.gitapi.controllers;

import java.util.List;

import com.gitapi.models.User;
import com.gitapi.services.GitHubRestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @Autowired
    GitHubRestService gitApiService;

    @Value("${api.gitgub.baseUrl}")
    public String baseUrl;

    @GetMapping("/")
    public String getHome() {
        return "index";
    }

    @GetMapping("/users")
    public String getUsers(@RequestParam String username, RedirectAttributes attributes) {
        attributes.addFlashAttribute("users", gitApiService.getUsers(username));
        return "redirect:/";
    }

}