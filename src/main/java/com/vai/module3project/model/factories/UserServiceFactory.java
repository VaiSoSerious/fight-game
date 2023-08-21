package com.vai.module3project.model.factories;

import com.vai.module3project.model.entity.User;
import com.vai.module3project.model.services.CRUDService;
import com.vai.module3project.model.services.UserService;

public class UserServiceFactory implements ServiceFactory<User> {
    @Override
    public CRUDService<User> createService() {
        return new UserService();
    }
}
