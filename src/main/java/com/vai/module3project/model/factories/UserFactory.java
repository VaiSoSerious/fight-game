package com.vai.module3project.model.factories;

import com.vai.module3project.model.entity.User;

public interface UserFactory {
    public User create(String login, String name, String email, String password);
}
