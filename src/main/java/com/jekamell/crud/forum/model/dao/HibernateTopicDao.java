package com.jekamell.crud.forum.model.dao;

import com.jekamell.crud.forum.model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("hibernateTopicDao")
public class HibernateTopicDao implements TopicDao {
    private SessionFactory sessionFactory;

    @Autowired
    public HibernateTopicDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addTopic(Topic topic, Integer categoryId) {

    }

    @Override
    public void saveTopic(Topic topic) {

    }

    @Override
    public List<Topic> getAllByCategory(Long categoryId) {
        return currentSession().createSQLQuery("SELECT * FROM topic WHERE id_category=:idc")
            .addEntity(Topic.class).setParameter("idc", categoryId).list();
    }
}
