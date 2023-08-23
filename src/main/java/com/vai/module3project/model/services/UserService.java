package com.vai.module3project.model.services;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.factories.UserFactory;

public interface UserService<T> extends CRUDService<T>{
    long isEntityExist(String login);

    UserFactory getUserFactory();

    boolean isCorrectPassword(String password, long id);

    boolean isEmailBusy(String email);
    boolean userHaveCharactersCheck(long id);
}
