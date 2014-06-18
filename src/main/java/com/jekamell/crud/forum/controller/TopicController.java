package com.jekamell.crud.forum.controller;

import com.jekamell.crud.forum.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TopicController {
    private ForumService forumService;

    @Autowired
    public void setForumService(ForumService forumService) {
        this.forumService = forumService;
    }

    @RequestMapping({"/category"})
    public String showCategoryList(Model model) {
        model.addAttribute(forumService.getAllCategory());

        return "list-category";
    }


    @RequestMapping({"/category/{id}"})
    public String showTopicsByCategory(@PathVariable(value = "id") final String id, Model model) {
        model.addAttribute("topicList", forumService.getTopicList(Long.parseLong(id)));
        return "list-topic";
    }

    public String showAddTopicForm(Model model) {
        return "topic/add";
    }
}
