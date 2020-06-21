package com.gitapi.controllers;

import com.gitapi.services.RepositoryService;
import com.gitapi.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @Autowired
    RepositoryService repositoryService;

    @Value("${api.gitgub.baseUrl}")
    public String baseUrl;

    @GetMapping("/")
    public String getHome() {
        return "homepage";
    }

    @GetMapping("/users")
    public String getUsers(@RequestParam String username, @RequestParam String sortBy,  @RequestParam String orderBy, Model model) {

        model.addAttribute("totalUsers", userService.getUsers(username, sortBy, orderBy).size());
        model.addAttribute("users", userService.getUsers(username, sortBy, orderBy));
        return "resultList";
    }

    @GetMapping("/repositories")
    public String getRespositories(@RequestParam String repository, @RequestParam String sortBy,  @RequestParam String orderBy, Model model) {

        model.addAttribute("totalRepositories", repositoryService.getRepositories(repository, sortBy, orderBy).size());
        model.addAttribute("repositories", repositoryService.getRepositories(repository, sortBy, orderBy));
        return "resultList";
    }

}