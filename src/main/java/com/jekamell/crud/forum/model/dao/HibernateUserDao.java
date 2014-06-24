package com.jekamell.crud.forum.model.dao;

import com.jekamell.crud.forum.model.User;
import com.jekamell.crud.forum.model.UserRole;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("hibernateUserDao")
public class HibernateUserDao extends SessionContainer implements UserDao {

    @Autowired
    public HibernateUserDao(SessionFactory sessionFactory, SecurityContextHolder securityContextHolder) {
        super(sessionFactory, securityContextHolder);
    }

    @Override
    public void addUser(User user) {
        user.setIdRole(UserRole.ROLE_USER);
        user.setEnabled(true);

        currentSession().save(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public User getUserByLogin(String userName) {
        Query query = currentSession().createQuery("from User where login = :login");
        query.setString("login", userName);
        List<User> users = query.list();
        if(!users.isEmpty()) {

            return users.get(0);
        }

        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public User getUserByEmail(String email) {
        Query query = currentSession().createQuery("from User where email = :email");
        query.setString("email", email);
        List<User> users = query.list();
        if (!users.isEmpty()) {

            return users.get(0);
        }

        return null;
    }

    @Override
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return getUserByLogin(auth.getName());
    }
}
