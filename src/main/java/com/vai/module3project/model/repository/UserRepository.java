package com.vai.module3project.model.repository;

public interface UserRepository<T> extends Repository<T> {
    long isExists(String login);

    boolean isCorrectPassword(String password, long id);

    boolean isEmailBusy(String email);
}
