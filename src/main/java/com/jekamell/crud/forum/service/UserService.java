package com.jekamell.crud.forum.service;

import com.jekamell.crud.forum.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void addUser(User user);
    void updateUser(User user);
    User getUserByUserName(String userName);
    User getUserByEmail(String email);
    User getCurrentUser();
}
