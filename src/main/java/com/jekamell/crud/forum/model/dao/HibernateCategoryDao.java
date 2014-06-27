package com.jekamell.crud.forum.model.dao;

import com.jekamell.crud.forum.model.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("hibernateCategoryDao")
public class HibernateCategoryDao extends SessionContainer implements CategoryDao {
    @Autowired
    public HibernateCategoryDao(SessionFactory sessionFactory, SecurityContextHolder securityContextHolder) {
        super(sessionFactory, securityContextHolder);
    }

    @Override
    public void add(Category category) {
        currentSession().save(category);
    }

    @Override
    public void update(Category category) {
        currentSession().update(category);
    }

    @Override
    public Category getById(Long id) {
        return (Category) currentSession().get(Category.class, id);
    }

    public List<Category> getAll() {
        return currentSession().createQuery("from Category").list();
    }
}
