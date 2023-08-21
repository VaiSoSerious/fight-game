package com.vai.module3project.model.services;

import java.util.Collection;
import java.util.Optional;

public interface CRUDService<T> {
    Collection<T> getAll();

    Optional<T> get(long id);

    void creat(T t);

    boolean isExists(String login, String password);
}
