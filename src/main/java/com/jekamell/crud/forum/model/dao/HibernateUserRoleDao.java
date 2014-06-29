package com.jekamell.crud.forum.model.dao;

import com.jekamell.crud.forum.model.UserRole;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("hibernateUserRoleDao")
public class HibernateUserRoleDao extends ModelDao implements UserRoleDao {

    @Override
    public UserRole getByRole(String code) {
        Query query = currentSession().createQuery("from UserRole where code = :code");
        query.setParameter("code", code);
        return (UserRole) getSingleRow(query.list());
    }
}
