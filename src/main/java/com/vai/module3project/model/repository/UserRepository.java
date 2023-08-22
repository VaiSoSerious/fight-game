package com.vai.module3project.model.repository;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.entity.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepository implements Repository<User>{
    private final Map<Long, User> userRepository = new HashMap<>();
    public static final AtomicLong id = new AtomicLong(0);

    public UserRepository() {
        Character[] characters = {new Character(true,1000,500,"godmod"),
                null, null, null, null};
        userRepository.put(id.incrementAndGet(),
                new User(id.get(),"gamemaster","gamemaster@test.com", "gamemaster", characters));
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
        userRepository.put(entity.getId(),entity);
    }
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
}
