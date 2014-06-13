package com.jekamell.crud.blog.service;

import com.jekamell.crud.blog.model.Post;
import java.util.List;

public interface BlogService {
    List<Post> getRecentPosts(int count);
    void savePost(Post post);
    Post getPost(Long id);
    void deletePost(Long id);
    List<Post> getAllPosts();
}
