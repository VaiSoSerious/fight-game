package com.vai.module3project.model.services;

import java.util.Collection;
import java.util.Optional;

public interface CRUDService<T> {
    Collection<T> getAllEntities();

    Optional<T> getEntity(long id);

    long saveEntity(T entity);
    void updateEntity(long id, T newEntity);


}
