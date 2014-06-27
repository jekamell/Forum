package com.jekamell.crud.forum.model.dao;

import com.jekamell.crud.forum.model.UserRole;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("hibernateUserRoleDao")
public class HibernateUserRoleDao extends SessionContainer implements UserRoleDao {
    @Autowired
    public HibernateUserRoleDao(SessionFactory sessionFactory, SecurityContextHolder securityContextHolder) {
        super(sessionFactory, securityContextHolder);
    }

    @Override
    public UserRole getRoleByCode(String code) {
        Query query = currentSession().createQuery("from UserRole where code = :code");
        query.setParameter("code", code);

        return (UserRole) query.list().get(0);
    }
}
