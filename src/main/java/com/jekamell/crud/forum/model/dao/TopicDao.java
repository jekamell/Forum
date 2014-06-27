package com.jekamell.crud.forum.model.dao;

import com.jekamell.crud.forum.model.Topic;

import java.util.List;

public interface TopicDao {
    void addTopic(Topic topic);
    List getAllByCategory(Long categoryId);
    Topic getTopic(Long id);
}
