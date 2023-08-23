package com.vai.module3project.model.services;

public interface UserService<T> extends CRUDService<T>{
    long isEntityExist(String login);


    boolean isCorrectPassword(String password, long id);
    boolean isEmailFreeCheck(String email);
}
