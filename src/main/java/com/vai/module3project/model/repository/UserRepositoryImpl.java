package com.vai.module3project.model.repository;

import com.vai.module3project.model.entity.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepositoryImpl implements UserRepository<User> {
    private final Map<Long, User> userRepository = new HashMap<>();
    public static final AtomicLong id = new AtomicLong(0);

    public UserRepositoryImpl() {

    }

    @Override
    public Collection<User> getAll() {
        return userRepository.values();
    }

    @Override
    public Optional<User> get(long id) {
        return Optional.ofNullable(userRepository.get(id));
    }

    @Override
    public void save(User entity) {
        entity.setId(id.incrementAndGet());
        userRepository.put(entity.getId(), entity);
    }

    @Override
    public void update(long id, User oldEntity) {

    }


    @Override
    public long isExists(String login) {
        for (User user : userRepository.values()) {
            if (user.getLogin().equals(login)) {
                return user.getId();
            }
        }
        return -1L;
    }

    @Override
    public boolean isCorrectPassword(String password, long id) {
        if (get(id).get().getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmailBusy(String email) {
        for (User user : userRepository.values()) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
