package com.jekamell.crud.blog.controller;

import com.jekamell.crud.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HomeController {
    public final static int POSTS_PER_PAGE = 20;

    private BlogService blogService;

    @Autowired
    public HomeController(BlogService blogService) {
        this.blogService = blogService;
    }

    @RequestMapping({"/", "/home"})
    public String showHomePage(Map<String, Object> model) {
        model.put("posts", blogService.getRecentPosts(POSTS_PER_PAGE));

        return "home";
    }
}
