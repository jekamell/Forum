package com.jekamell.crud.forum.model.dao;

import com.jekamell.crud.forum.model.Topic;
import com.jekamell.crud.forum.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("hibernateTopicDao")
public class HibernateTopicDao extends SessionContainer implements TopicDao {
    @Autowired
    private UserService userService;

    @Autowired
    public HibernateTopicDao(SessionFactory sessionFactory, SecurityContextHolder securityContextHolder) {
        super(sessionFactory, securityContextHolder);
    }

    @Override
    public void add(Topic topic) {
        topic.setAuthor(userService.getLogged());
        currentSession().save(topic);
    }

    @Override
    public Topic getById(Long id) {
        return (Topic) currentSession().get(Topic.class, id);
    }

    @Override
    public List<Topic> getAllByCategoryId(Long id) {
        return currentSession().createQuery("from Topic where id_category=:idc").setParameter("idc", id).list();
    }
}
