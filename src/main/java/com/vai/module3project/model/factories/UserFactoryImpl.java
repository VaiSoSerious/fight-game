package com.vai.module3project.model.factories;

import com.vai.module3project.model.entity.User;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class UserFactoryImpl implements UserFactory {
    private static UserFactory userFactory;

    private UserFactoryImpl() {
        log.info("Создали новую Фабрику пользователей");
    }

    public static UserFactory getUserFactory() {
        if (userFactory == null) {
            userFactory = new UserFactoryImpl();
        }
        log.info("Получили Фабрику пользователей");
        return userFactory;
    }

    @Override
    public User create(String login, String name, String email, String password) {
        User user = new User();
        user.setLogin(login);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        log.info("Создали нового пользователя: " + name + " с почтой: " + email);
        return user;
    }
}
