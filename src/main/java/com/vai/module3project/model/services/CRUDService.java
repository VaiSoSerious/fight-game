package com.vai.module3project.model.services;

import java.util.Collection;
import java.util.Optional;

public interface CRUDService<T> {
    Collection<T> getAllEntities();

    Optional<T> getEntity(long id);

    void saveEntity(T t);

    long isEntityExist(String login);


    boolean isCorrectPassword(String password, long id);
}
