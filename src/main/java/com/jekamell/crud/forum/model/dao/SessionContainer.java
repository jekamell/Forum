package com.jekamell.crud.forum.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

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

}
