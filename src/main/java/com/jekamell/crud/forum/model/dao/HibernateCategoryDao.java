package com.jekamell.crud.forum.model.dao;

import com.jekamell.crud.forum.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("hibernateCategoryDao")
public class HibernateCategoryDao implements CategoryDao {
    private SessionFactory sessionFactory;

    @Autowired
    public HibernateCategoryDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public  Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addCategory(Category category) {
        currentSession().save(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        return (Category) currentSession().get(Category.class, id);
    }

    @Override
    public void saveCategory(Category category) {
        currentSession().update(category);
    }

    public List getAll() {
        return currentSession().createSQLQuery("SELECT * FROM `category`").addEntity(Category.class).list();
    }
}
