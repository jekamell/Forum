package com.jekamell.crud.forum.service;

import com.jekamell.crud.forum.model.User;
import com.jekamell.crud.forum.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    private UserDao hibernateUserDao;

    @Autowired
    public UserServiceImpl(UserDao hibernateUserDao) {
        this.hibernateUserDao = hibernateUserDao;
    }

    @Override
    public void addUser(User user) {
        hibernateUserDao.addUser(user);
    }

    @Override
    public User getUserByUserName(String userName) {
        return hibernateUserDao.getUser(userName);
    }
}
