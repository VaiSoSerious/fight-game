package com.vai.module3project.model.services;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.repository.EnemyCharacterRepository;
import com.vai.module3project.model.repository.Repository;

import java.util.Collection;
import java.util.Optional;

public class EnemyCharacterService implements CRUDService<Character> {
    private final Repository<Character> enemyCharacterRepository = new EnemyCharacterRepository();

    @Override
    public Collection<Character> getAllEntities() {
        return enemyCharacterRepository.getAll();
    }

    @Override
    public Optional<Character> getEntity(long id) {
        return enemyCharacterRepository.get(id);
    }

    @Override
    public void saveEntity(Character character) {
        enemyCharacterRepository.save(character);
    }

    @Override
    public long isEntityExist(String login) {
        return -1L;
    }

    @Override
    public boolean isCorrectPassword(String password, long id) {
        return false;
    }
}
