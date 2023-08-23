package com.vai.module3project.model.services;

import com.vai.module3project.model.entity.User;
import com.vai.module3project.model.repository.UserRepository;
import com.vai.module3project.model.repository.UserRepositoryImpl;
import lombok.extern.log4j.Log4j2;

import java.util.Collection;
import java.util.Optional;

@Log4j2
public class UserServiceImpl implements UserService<User> {
    private final UserRepository<User> userRepository = new UserRepositoryImpl();
    private static UserServiceImpl userService;

    public UserServiceImpl() {
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
    public void saveEntity(User user) {
        log.info("Сохраняем нового пользователя с id#: " + (getAllEntities().size() + 1) + " лог: " + user.getLogin());
        userRepository.save(user);
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
    public boolean isCorrectPassword(String password, long id) {
        boolean result = userRepository.isCorrectPassword(password, id);
        log.info("Проверка на корректность пароля пользователя id#: " + id + " Результат: " + result);
        return result;
    }

    @Override
    public boolean isEmailFreeCheck(String email) {
        return false;
    }
}
