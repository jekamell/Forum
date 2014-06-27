package com.jekamell.crud.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForumController extends com.jekamell.crud.forum.controller.Controller {
    @RequestMapping({"/", "/home"})
    public String showHomePage(Model model) {
        return "redirect:/category";
    }
}
