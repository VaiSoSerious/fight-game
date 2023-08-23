package com.vai.module3project.model.services;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.entity.User;
import com.vai.module3project.model.factories.UserFactory;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Getter
@Log4j2
public class ServiceLocator {
    private final UserService<User> userService;
    private final CharacterService<Character> characterService;
    private static ServiceLocator serviceLocator;

    private ServiceLocator() {
        userService = UserServiceImpl.getUserService();
        characterService = CharacterServiceImpl.getCharacterService();
        log.info("Создалий новый Сервис локатор");
    }

    public static ServiceLocator getServiceLocator() {
        if (serviceLocator == null) {
            serviceLocator = new ServiceLocator();
        }
        log.info("Получили Сервис локатор");
        return serviceLocator;
    }
}
