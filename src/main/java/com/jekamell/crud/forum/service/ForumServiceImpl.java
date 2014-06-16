package com.jekamell.crud.forum.service;

import com.jekamell.crud.forum.model.Category;
import com.jekamell.crud.forum.model.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("forumService")
public class ForumServiceImpl implements ForumService {
    private CategoryDao hibernateCategoryDao;

    @Autowired
    public ForumServiceImpl(CategoryDao hibernateCategoryDao) {
        this.hibernateCategoryDao = hibernateCategoryDao;
    }

    @Override
    public List<Category> getAllCategory() {
        return hibernateCategoryDao.getAll();
    }
}
