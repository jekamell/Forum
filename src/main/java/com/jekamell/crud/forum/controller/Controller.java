package com.jekamell.crud.forum.controller;

import com.jekamell.crud.forum.model.Category;
import com.jekamell.crud.forum.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Transactional
public class Controller {
    @Autowired
    private ForumService forumService;
    private static List<Category> categories;

    @ModelAttribute("menuCategories")
    public List<Category> getCategoriesForMenu() {
        if (categories == null) {
            categories = forumService.getAllCategory();
        }
        return categories;
    }
}
