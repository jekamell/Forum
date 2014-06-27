package com.jekamell.crud.forum.model.dao;

import com.jekamell.crud.forum.model.User;

public interface UserDao {
    void add(User user);
    void update(User user);
    User getByLogin(String userName);
    User getByEmail(String email);
    User getLogged();
}
