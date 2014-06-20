package com.jekamell.crud.forum.model.dao;

import com.jekamell.crud.forum.model.User;

public interface UserDao {
    void addUser(User user);
    User getUserByLogin(String userName);
    User getUserByEmail(String email);
}
