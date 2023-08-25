package com.vai.module3project.model.repository;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.entity.Class;
import lombok.extern.log4j.Log4j2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
@Log4j2
public class CharacterRepositoryImpl implements CharacterRepository<Character> {

    public final Map<Long, Character> enemyCharacterRepository = new HashMap<>();
    public static final AtomicLong id = new AtomicLong();

    public CharacterRepositoryImpl() {
        Character character = new Character(false, 85, 3, "Местный забулдыга", Class.ENEMY);
        String name = character.getName();
        log.info("Создаем нового игрового персонажа: " + name);
        enemyCharacterRepository.put(id.incrementAndGet(), character);
    }

    @Override
    public Collection<Character> getAll() {
        log.info("Получаем всех игровых персонажей.");
        return enemyCharacterRepository.values();
    }

    @Override
    public Optional<Character> get(long id) {
        Optional<Character> character = Optional.ofNullable(enemyCharacterRepository.get(id));
        log.info("Получаем персонажа: " + character.get() + " по id#: " + id);
        return character;
    }

    @Override
    public void save(Character entity) {
        long currentId = id.incrementAndGet();
        log.info("Сохраняем персонажа: " + entity + " с id#: " + currentId);
        enemyCharacterRepository.put(currentId, entity);
    }

    @Override
    public void update(long id, Character oldEntity) {

    }
}
