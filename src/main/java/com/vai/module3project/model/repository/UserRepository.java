package com.vai.module3project.model.repository;

import com.vai.module3project.model.entity.User;

public interface UserRepository<T> extends Repository<T> {
    long isExists(String login);

    boolean isCorrectPassword(String password, long id);

    boolean isEmailFreeCheck(String email);
}
