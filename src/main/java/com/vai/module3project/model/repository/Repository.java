package com.vai.module3project.model.repository;

import java.util.Collection;
import java.util.Optional;

public interface Repository<T> {
    Collection<T> getAll();

    Optional<T> get(long id);

    void save(T entity);
    void update(long id, T oldEntity);

}
