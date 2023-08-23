package com.vai.module3project.model.factories;

import com.vai.module3project.model.services.UserService;

public interface UserServiceFactory<T> {
    UserService<T> createService();
}
