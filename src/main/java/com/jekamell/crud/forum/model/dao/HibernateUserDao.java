package com.jekamell.crud.forum.model.dao;

import com.jekamell.crud.forum.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("hibernateUserDao")
@Transactional
public class HibernateUserDao extends SessionContainer implements UserDao {
    @Autowired
    public HibernateUserDao(SessionFactory sessionFactory, SecurityContextHolder securityContextHolder) {
        super(sessionFactory, securityContextHolder);
    }

    @Override
    public void add(User user) {
        currentSession().save(user);
    }

    @Override
    public void update(User user) {
        currentSession().merge(user);
    }

    @Override
    public User getByLogin(String userName) {
        Query query = currentSession().createQuery("from User where login=:login");
        query.setString("login", userName);
        return (User) getSingleRow(query.list());
    }

    @Override
    public User getByEmail(String email) {
        Query query = currentSession().createQuery("from User where email=:email");
        query.setString("email", email);
        return (User) getSingleRow(query.list());
    }

    @Override
    public User getLogged() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return getByLogin(auth.getName());
    }
}
