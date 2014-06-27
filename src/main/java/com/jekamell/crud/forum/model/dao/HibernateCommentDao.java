package com.jekamell.crud.forum.model.dao;

import com.jekamell.crud.forum.model.Comment;
import com.jekamell.crud.forum.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service("hibernateCommentDao")
public class HibernateCommentDao extends SessionContainer implements CommentDao {
    private UserService userService;

    @Autowired
    public HibernateCommentDao(SessionFactory sessionFactory, SecurityContextHolder securityContextHolder) {
        super(sessionFactory, securityContextHolder);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void addComment(Comment comment) {
        Authentication auth = getSecurityContextHolder().getContext().getAuthentication();
        comment.setAuthor(userService.getUserByUserName(auth.getName()));

        currentSession().save(comment);
    }
}
