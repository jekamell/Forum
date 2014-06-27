package com.jekamell.crud.forum.model.dao;

import com.jekamell.crud.forum.model.Category;
import java.util.List;

public interface CategoryDao {
    void add(Category category);
    void update(Category category);
    Category getById(Long id);
    List getAll();
}
