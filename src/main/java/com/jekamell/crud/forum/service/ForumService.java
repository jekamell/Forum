package com.jekamell.crud.forum.service;

import com.jekamell.crud.forum.model.Post;
import java.util.List;

public interface ForumService {
    List<Post> getRecentPosts(int count);
    void savePost(Post post);
    Post getPost(Long id);
    void deletePost(Long id);
    List<Post> getAllPosts();
}
