package com.jekamell.crud.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForumController {
    @RequestMapping({"/", "/home"})
    public String showHomePage(Model model) {
        return "redirect:/category";
    }
}
