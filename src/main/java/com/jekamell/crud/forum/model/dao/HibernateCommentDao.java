package com.jekamell.crud.forum.model.dao;

import com.jekamell.crud.forum.model.Comment;
import com.jekamell.crud.forum.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("hibernateCommentDao")
public class HibernateCommentDao extends SessionContainer implements CommentDao {
    @Autowired
    private UserService userService;

    @Autowired
    public HibernateCommentDao(SessionFactory sessionFactory, SecurityContextHolder securityContextHolder) {
        super(sessionFactory, securityContextHolder);
    }

    @Override
    public void add(Comment comment) {
        comment.setAuthor(userService.getLogged());

        currentSession().save(comment);
    }
}
