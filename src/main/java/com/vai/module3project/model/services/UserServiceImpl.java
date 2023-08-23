package com.vai.module3project.model.services;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.entity.User;
import com.vai.module3project.model.factories.UserFactory;
import com.vai.module3project.model.factories.UserFactoryImpl;
import com.vai.module3project.model.repository.UserRepository;
import com.vai.module3project.model.repository.UserRepositoryImpl;
import lombok.extern.log4j.Log4j2;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Log4j2
public class UserServiceImpl implements UserService<User> {
    private final UserRepository<User> userRepository = new UserRepositoryImpl();
    private static UserServiceImpl userService;
    private final UserFactory userFactory;


    public UserServiceImpl() {
        userFactory = UserFactoryImpl.getUserFactory();
        log.info("Создалий новую Реализацию пользовательского сервиса.");
    }

    public static UserServiceImpl getUserService() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        log.info("Получили Реализацию пользовательского сервиса.");
        return userService;
    }

    @Override
    public Collection<User> getAllEntities() {
        Collection<User> users = userRepository.getAll();
        log.info("Получаем полный список пользователей из базы. Кол-во: " + users.size());
        return users;
    }

    @Override
    public Optional<User> getEntity(long id) {
        Optional<User> user = userRepository.get(id);
        if (user.isPresent()) {
            log.info("Получаем пользователя с id#: " + id);
        } else {
            log.info("Пользователь с id#: " + id + " отсутствует");
        }
        return user;
    }

    @Override
    public long saveEntity(User user) {
        long id = getAllEntities().size() + 1;
        log.info("Сохраняем нового пользователя: " + user.getName()
                + " с почтой: " + user.getEmail() + " с id#: " + id);
        userRepository.save(user);
        return id;
    }

    @Override
    public void updateEntity(long id, User newUser) {
        userRepository.update(id,newUser);
    }

    @Override
    public long isEntityExist(String login) {
        long userId = userRepository.isExists(login);
        if (userId >= 0) {
            log.info("Проверка на наличие пользователя по логину нашла пользователя с id#: " + userId);
        } else {
            log.info("Проверка на наличие пользователя по логину не нашла пользователя " + login);
        }
        return userId;
    }

    @Override
    public UserFactory getUserFactory() {
        return userFactory;
    }

    @Override
    public boolean isCorrectPassword(String password, long id) {
        boolean result = userRepository.isCorrectPassword(password, id);
        log.info("Проверка на корректность пароля пользователя id#: " + id + " Результат: " + result);
        return result;
    }

    @Override
    public boolean isEmailBusy(String email) {
        boolean result = userRepository.isEmailBusy(email);
        log.info("Проверка на занятость электронной почты: " + email + " Результат: " + result);
        return result;
    }

    @Override
    public boolean userHaveCharactersCheck(long id) {
        List<Character> characters = getEntity(id).get().getCharacters();
        for (Character character : characters) {
            if (character != null) {
                log.info("Проверка на наличие персонажей у пользователя с id#: " + id + " Результат: " + true);
                return true;
            }
        }
        log.info("Проверка на наличие персонажей у пользователя с id#: " + id + " Результат: " + false);
        return false;
    }

    @Override
    public void creatNewCharacter(long id, Character character) {
        log.info("Создание нового персонажа: " + character.getName() + " у пользователя с id#: " + id);
        getEntity(id).get().getCharacters().add(character);
    }

    @Override
    public void deleteCharacter(long id, String character) {
        Character characterForDeleting = null;
        for (Character c : getEntity(id).get().getCharacters()) {
            if (c.getName().equals(character)) {
                characterForDeleting = c;
            }
        }
        if (characterForDeleting != null) {
            getEntity(id).get().getCharacters().remove(characterForDeleting);
            log.info("Удаление персонажа: " + character + " у пользователя с id#: " + id);
        } else {
            log.info("Персонаж: " + character + " у пользователя с id#: " + id + " не найден.");
        }
    }

}
