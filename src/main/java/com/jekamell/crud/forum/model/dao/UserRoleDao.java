package com.jekamell.crud.forum.model.dao;

import com.jekamell.crud.forum.model.UserRole;

public interface UserRoleDao {
    UserRole getRoleByCode(String code);
}
