package com.jekamell.crud.blog.service;

import com.jekamell.crud.blog.model.Post;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogServiceImpl implements BlogService {
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
