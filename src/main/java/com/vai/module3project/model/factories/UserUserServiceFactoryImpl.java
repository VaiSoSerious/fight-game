package com.vai.module3project.model.factories;

import com.vai.module3project.model.entity.User;
import com.vai.module3project.model.services.UserService;
import com.vai.module3project.model.services.UserServiceImpl;

public class UserUserServiceFactoryImpl implements UserServiceFactory<User> {
    @Override
    public UserService<User> createService() {
        return new UserServiceImpl();
    }
}
