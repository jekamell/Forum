package com.jekamell.crud.forum.model.dao;

import com.jekamell.crud.forum.model.Category;

import java.util.List;

public interface CategoryDao {
    void addCategory(Category category);
    void saveCategory(Category category);
    Category getCategoryById(Long id);
    List getAll();
}
