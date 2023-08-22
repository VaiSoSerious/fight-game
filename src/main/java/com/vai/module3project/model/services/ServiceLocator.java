package com.vai.module3project.model.services;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.entity.User;
import com.vai.module3project.model.factories.EnemyCharacterServiceFactory;
import com.vai.module3project.model.factories.ServiceFactory;
import com.vai.module3project.model.factories.UserServiceFactory;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Getter
@Log4j2
public class ServiceLocator {
    private final CRUDService<User> userService;
    private final CRUDService<Character> enemyCharacterService;
    private static ServiceLocator serviceLocator;

    private ServiceLocator() {
        ServiceFactory<User> userServiceFactory = createFactory("user");
        userService = userServiceFactory.createService();
        ServiceFactory<Character> enemyCharacterServiceFactory = createFactory("enemy");
        enemyCharacterService = enemyCharacterServiceFactory.createService();
        log.info("Создалий новый Сервис локатор");
    }

    public static ServiceLocator getServiceLocator() {
        if (serviceLocator == null) {
            serviceLocator = new ServiceLocator();
        }
        log.info("Получили Сервис локатор");
        return serviceLocator;
    }

    private ServiceFactory createFactory(String name) {
        switch (name) {
            case "user" -> {
                log.info("Создали фабрику для создания пользователей");
                return new UserServiceFactory();
            }
            case "enemy" -> {
                log.info("Создали фабрику для создания персонажей врагов");
                return new EnemyCharacterServiceFactory();
            }
            default -> throw new RuntimeException(name + "неизвестная фабрика");
        }
    }
}
