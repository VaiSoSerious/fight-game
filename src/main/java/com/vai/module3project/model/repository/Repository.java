package com.vai.module3project.model.repository;

import java.util.Collection;
import java.util.Optional;

public interface Repository<T> {
    Collection<T> getAll();

    Optional<T> get(long id);

    void creat(T entity);

    boolean isExists(String login, String password);
}
