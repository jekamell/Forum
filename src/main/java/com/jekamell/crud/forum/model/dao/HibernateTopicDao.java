package com.jekamell.crud.forum.model.dao;

import com.jekamell.crud.forum.model.Topic;
import com.jekamell.crud.forum.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("hibernateTopicDao")
public class HibernateTopicDao extends SessionContainer implements TopicDao {

    @Autowired
    public HibernateTopicDao(SessionFactory sessionFactory, SecurityContextHolder securityContextHolder) {
        super(sessionFactory, securityContextHolder);
    }

    @Override
    public void addTopic(Topic topic) {
        User author = (User) getSecurityContextHolder().getContext().getAuthentication().getPrincipal();
        topic.setId_author(author.getId());
        currentSession().save(topic);
    }

    @Override
    public void saveTopic(Topic topic) {

    }

    @Override
    public List<Topic> getAllByCategory(Long categoryId) {
        return currentSession().createSQLQuery("SELECT * FROM topic WHERE id_category=:idc")
            .addEntity(Topic.class).setParameter("idc", categoryId).list();
    }

    @Override
    public Topic getTopic(Long id) {
        Query query = currentSession().createQuery("from Topic where id=:id");
        query.setParameter("id", id);
        List<Topic> topics = query.list();
        if (!topics.isEmpty()) {
             return topics.get(0);
        }

        return null;
    }
}
