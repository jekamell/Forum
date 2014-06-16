package com.jekamell.crud.forum.service;

import com.jekamell.crud.forum.model.Category;
import com.jekamell.crud.forum.model.Topic;

import java.util.List;

public interface ForumService {
    List<Category> getAllCategory();
    List<Topic> getTopicList(Long categoryId);

}
