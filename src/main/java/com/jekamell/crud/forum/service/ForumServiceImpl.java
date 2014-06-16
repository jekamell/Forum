package com.jekamell.crud.forum.service;

import com.jekamell.crud.forum.model.Category;
import com.jekamell.crud.forum.model.Topic;
import com.jekamell.crud.forum.model.dao.CategoryDao;
import com.jekamell.crud.forum.model.dao.TopicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("forumService")
public class ForumServiceImpl implements ForumService {
    private CategoryDao hibernateCategoryDao;
    private TopicDao hibernateTopicDao;

    @Autowired
    public ForumServiceImpl(CategoryDao hibernateCategoryDao, TopicDao hibernateTopicDao) {
        this.hibernateCategoryDao = hibernateCategoryDao;
        this.hibernateTopicDao = hibernateTopicDao;

    }

    @Override
    public List<Category> getAllCategory() {
        return hibernateCategoryDao.getAll();
    }

    @Override
    public List<Topic> getTopicList(Long categoryId) {
        return hibernateTopicDao.getAllByCategory(categoryId);
    }
}
