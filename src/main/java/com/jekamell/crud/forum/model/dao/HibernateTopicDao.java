package com.jekamell.crud.forum.model.dao;

import com.jekamell.crud.forum.model.Topic;
import com.jekamell.crud.forum.model.User;
import com.jekamell.crud.forum.service.UserService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("hibernateTopicDao")
public class HibernateTopicDao extends SessionContainer implements TopicDao {
    private UserService userService;

    @Autowired
    public HibernateTopicDao(SessionFactory sessionFactory, SecurityContextHolder securityContextHolder) {
        super(sessionFactory, securityContextHolder);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void addTopic(Topic topic) {
        topic.setAuthor(userService.getCurrentUser());
        currentSession().save(topic);
    }

    @Override
    public List<Topic> getAllByCategory(Long categoryId) {
        return currentSession().createSQLQuery("SELECT * FROM topic WHERE id_category=:idc")
            .addEntity(Topic.class).setParameter("idc", categoryId).list();
    }

    @Override
    public Topic getTopic(Long id) {
        return (Topic) currentSession().get(Topic.class, id);
    }
}
