package com.jekamell.crud.forum.model.dao;

import com.jekamell.crud.forum.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("hibernateUserDao")
public class HibernateUserDao extends SessionContainer implements UserDao {

    @Autowired
    public HibernateUserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void addUser(User user) {
        currentSession().save(user);
    }

    @Override
    public User getUser(String userName) {
        return (User) currentSession().createSQLQuery("SELECT * FROM user where login = :username")
            .addEntity(User.class)
            .setParameter("username", userName).uniqueResult();
    }
}
