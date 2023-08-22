package com.vai.module3project.model.repository;

import java.util.Collection;
import java.util.Optional;

public interface Repository<T> {
    Collection<T> getAll();

    Optional<T> get(long id);

    void save(T entity);

    long isExists(String login);
    boolean isCorrectPassword(String password, long id);
}
