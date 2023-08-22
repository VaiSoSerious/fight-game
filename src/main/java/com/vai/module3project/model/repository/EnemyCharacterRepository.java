package com.vai.module3project.model.repository;

import com.vai.module3project.model.entity.Character;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class EnemyCharacterRepository implements Repository<Character>{

    public final Map<Long,Character> enemyCharacterRepository = new HashMap<>();
    public static final AtomicLong id = new AtomicLong();

    public EnemyCharacterRepository() {
        enemyCharacterRepository.put(id.incrementAndGet(),new Character(false,85,3,"Местный забулдыга"));
    }

    @Override
    public Collection<Character> getAll() {
        return enemyCharacterRepository.values();
    }

    @Override
    public Optional<Character> get(long id) {
        return Optional.ofNullable(enemyCharacterRepository.get(id));
    }

    @Override
    public void save(Character entity) {
        enemyCharacterRepository.put(id.incrementAndGet(),entity);
    }

    @Override
    public long isExists(String login) {
        return -1L;
    }

    @Override
    public boolean isCorrectPassword(String password, long id) {
        return false;
    }

}