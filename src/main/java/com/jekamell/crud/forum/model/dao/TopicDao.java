package com.jekamell.crud.forum.model.dao;

import com.jekamell.crud.forum.model.Topic;
import java.util.List;

public interface TopicDao {
    void add(Topic topic);
    List getAllByCategoryId(Long categoryId);
    Topic getById(Long id);
}
