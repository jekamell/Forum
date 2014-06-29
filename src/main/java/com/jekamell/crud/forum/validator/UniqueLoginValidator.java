package com.jekamell.crud.forum.validator;

import com.jekamell.crud.forum.model.User;
import com.jekamell.crud.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UniqueLoginValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (!(userService.getUserByUserName(user.getLogin()) == null
            || userService.getUserByUserName(user.getLogin()).getId() == user.getId())
        ) {
            errors.rejectValue("login", "", "This login name already taken"); // TODO: message sources
        }
    }
}
