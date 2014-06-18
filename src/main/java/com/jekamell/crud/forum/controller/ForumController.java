package com.jekamell.crud.forum.controller;

import com.jekamell.crud.forum.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForumController {
    @RequestMapping({"/", "/home"})
    public String showHomePage(Model model) {
        return "redirect:/category";
    }
}
