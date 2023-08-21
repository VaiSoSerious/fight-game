package com.vai.module3project.model.factories;

import com.vai.module3project.model.services.CRUDService;

public interface ServiceFactory<T> {
    CRUDService<T> createService();
}
