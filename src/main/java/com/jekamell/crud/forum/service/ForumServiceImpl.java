package com.jekamell.crud.forum.service;

import com.jekamell.crud.forum.model.Post;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ForumServiceImpl implements ForumService {
    @Override
    public List<Post> getRecentPosts(int count) {
        return null;
    }

    @Override
    public void savePost(Post post) {

    }

    @Override
    public Post getPost(Long id) {
        return null;
    }

    @Override
    public void deletePost(Long id) {

    }

    @Override
    public List<Post> getAllPosts() {
        return null;
    }
}
