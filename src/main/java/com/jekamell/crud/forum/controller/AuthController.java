package com.jekamell.crud.forum.controller;

import com.jekamell.crud.forum.model.User;
import com.jekamell.crud.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController extends com.jekamell.crud.forum.controller.Controller {
    @Autowired
    private UserService userService;

    @RequestMapping({"/login"})
    public String login() {
        return "auth-form";
    }
}
