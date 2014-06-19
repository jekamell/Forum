package com.jekamell.crud.forum.service;

import com.jekamell.crud.forum.model.Category;
import com.jekamell.crud.forum.model.Comment;
import com.jekamell.crud.forum.model.Topic;
import com.jekamell.crud.forum.model.User;
import com.jekamell.crud.forum.model.dao.CategoryDao;
import com.jekamell.crud.forum.model.dao.CommentDao;
import com.jekamell.crud.forum.model.dao.TopicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("forumService")
public class ForumServiceImpl implements ForumService {
    private CategoryDao hibernateCategoryDao;
    private TopicDao hibernateTopicDao;
    private CommentDao hibernateCommentDao;

    @Autowired
    public void setHibernateCategoryDao(CategoryDao hibernateCategoryDao) {
        this.hibernateCategoryDao = hibernateCategoryDao;
    }
    @Autowired
    public void setHibernateTopicDao(TopicDao hibernateTopicDao) {
        this.hibernateTopicDao = hibernateTopicDao;
    }
    @Autowired
    public void setHibernateCommentDao(CommentDao hibernateCommentDao) {
        this.hibernateCommentDao = hibernateCommentDao;
    }

    @Override
    public List<Category> getAllCategory() {
        return hibernateCategoryDao.getAll();
    }

    @Override
    public List<Topic> getTopicList(Long categoryId) {
        return hibernateTopicDao.getAllByCategory(categoryId);
    }

    @Override
    public void addTopic(Topic topic) {
        hibernateTopicDao.addTopic(topic);
    }

    @Override
    public Topic getTopic(Long id) {
        return hibernateTopicDao.getTopic(id);
    }

    @Override
    public void addComment(Comment comment) {
        System.out.println("comment: " + comment.getContent());
        hibernateCommentDao.addComment(comment);
    }
}
