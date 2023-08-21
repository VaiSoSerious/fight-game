package com.vai.module3project.model.services;

import com.vai.module3project.model.entity.User;
import com.vai.module3project.model.repository.Repository;
import com.vai.module3project.model.repository.UserRepository;

import java.util.Collection;
import java.util.Optional;

public class UserService implements CRUDService<User> {
    private final Repository<User> userRepository = new UserRepository();

    @Override
    public Collection<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public Optional<User> get(long id) {
        return userRepository.get(id);
    }

    @Override
    public void creat(User user) {
        userRepository.creat(user);
    }

    @Override
    public boolean isExists(String login, String password) {
        return userRepository.isExists(login, password);
    }
}
