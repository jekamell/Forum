package com.jekamell.crud.forum.model.dao;

import com.jekamell.crud.forum.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

class SessionContainer {
    private SessionFactory sessionFactory;
    private SecurityContextHolder securityContextHolder;

    public SessionContainer(SessionFactory sessionFactory, SecurityContextHolder securityContextHolder) {
        this.sessionFactory = sessionFactory;
        this.securityContextHolder = securityContextHolder;
    }

    protected SecurityContextHolder getSecurityContextHolder() {
        return securityContextHolder;
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    protected Object getSingleRow(List<Object> list) {
        return list.isEmpty() ? null : list.get(0);
    }

}
