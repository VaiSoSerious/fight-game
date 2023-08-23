package com.vai.module3project.model.factories;

import com.vai.module3project.model.services.CRUDService;
import com.vai.module3project.model.services.UserService;

public interface CharacterServiceFactory<T> {
    CRUDService<T> createService();
}
