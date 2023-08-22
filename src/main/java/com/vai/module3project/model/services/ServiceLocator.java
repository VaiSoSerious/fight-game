package com.vai.module3project.model.services;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.entity.User;
import com.vai.module3project.model.factories.EnemyCharacterServiceFactory;
import com.vai.module3project.model.factories.ServiceFactory;
import com.vai.module3project.model.factories.UserServiceFactory;
import lombok.Getter;

@Getter
public class ServiceLocator {
    private final CRUDService<User> userService;
    private final CRUDService<Character> enemyCharacterService;
    private static ServiceLocator serviceLocator;

    private ServiceLocator() {
        ServiceFactory<User> userServiceFactory = createFactory("user");
        userService = userServiceFactory.createService();
        ServiceFactory<Character> enemyCharacterServiceFactory = createFactory("enemy");
        enemyCharacterService = enemyCharacterServiceFactory.createService();
    }

    public static ServiceLocator getServiceLocator() {
        if (serviceLocator == null) {
            serviceLocator = new ServiceLocator();
        }
        return serviceLocator;
    }

    private ServiceFactory createFactory(String name) {
        switch (name) {
            case "user" -> {
                return new UserServiceFactory();
            }
            case "enemy" -> {
                return new EnemyCharacterServiceFactory();
            }
            default -> throw new RuntimeException(name + "неизвестная фабрика");
        }
    }
}
