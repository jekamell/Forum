package com.jekamell.crud.forum.controller;

import com.jekamell.crud.forum.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HomeController {
    public final static int POSTS_PER_PAGE = 20;

    private ForumService forumService;

    @Autowired
    public HomeController(ForumService forumService) {
        this.forumService = forumService;
    }

    @RequestMapping({"/", "/home"})
    public String showHomePage(Map<String, Object> model) {
        model.put("posts", forumService.getRecentPosts(POSTS_PER_PAGE));

        return "home";
    }
}
