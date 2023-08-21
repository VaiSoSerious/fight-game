package com.vai.module3project.model.services;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.repository.EnemyCharacterRepository;
import com.vai.module3project.model.repository.Repository;

import java.util.Collection;
import java.util.Optional;

public class EnemyCharacterService implements CRUDService<Character> {
    private final Repository<Character> enemyCharacterRepository = new EnemyCharacterRepository();

    @Override
    public Collection<Character> getAll() {
        return enemyCharacterRepository.getAll();
    }

    @Override
    public Optional<Character> get(long id) {
        return enemyCharacterRepository.get(id);
    }

    @Override
    public void creat(Character character) {
        enemyCharacterRepository.creat(character);
    }

    @Override
    public boolean isExists(String login, String password) {
        return false;
    }
}
