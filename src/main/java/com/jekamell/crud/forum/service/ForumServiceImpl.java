package com.jekamell.crud.forum.service;

import com.jekamell.crud.forum.model.Category;
import com.jekamell.crud.forum.model.Comment;
import com.jekamell.crud.forum.model.Topic;
import com.jekamell.crud.forum.model.dao.CategoryDao;
import com.jekamell.crud.forum.model.dao.CommentDao;
import com.jekamell.crud.forum.model.dao.TopicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("forumService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ForumServiceImpl implements ForumService {
    @Autowired
    private CategoryDao hibernateCategoryDao;
    @Autowired
    private TopicDao hibernateTopicDao;
    @Autowired
    private CommentDao hibernateCommentDao;

    @Override
    public List<Category> getAllCategory() {
        return hibernateCategoryDao.getAll();
    }

    @Override
    public List<Topic> getTopicList(Long categoryId) {
        return hibernateTopicDao.getAllByCategoryId(categoryId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addTopic(Topic topic) {
        hibernateTopicDao.add(topic);
    }

    @Override
    public Topic getTopic(Long id) {
        return hibernateTopicDao.getById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addComment(Comment comment) {
        hibernateCommentDao.add(comment);
    }

    @Override
    public Category getCategory(Long id) {
        return hibernateCategoryDao.getById(id);
    }
}
