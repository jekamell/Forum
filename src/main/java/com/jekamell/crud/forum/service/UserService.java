package com.jekamell.crud.forum.service;

import com.jekamell.crud.forum.model.User;

public interface UserService {
    void addUser(User user);
    User getUserByUserName(String userName);
}
