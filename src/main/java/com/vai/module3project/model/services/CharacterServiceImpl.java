package com.vai.module3project.model.services;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.factories.CharacterFactory;
import com.vai.module3project.model.factories.CharacterFactoryImpl;
import com.vai.module3project.model.repository.CharacterRepositoryImpl;
import com.vai.module3project.model.repository.Repository;
import lombok.extern.log4j.Log4j2;

import java.util.Collection;
import java.util.Optional;

@Log4j2
public class CharacterServiceImpl implements CharacterService<Character> {
    private final Repository<Character> characterRepository = new CharacterRepositoryImpl();
    private static CharacterServiceImpl characterService;
    private static CharacterFactory characterFactory;

    public CharacterFactory getCharacterFactory() {
        return characterFactory;
    }

    public CharacterServiceImpl() {
        characterFactory = CharacterFactoryImpl.getCharacterFactory();
        log.info("Создалий новую Реализацию сервиса персонажей.");
    }

    public static CharacterServiceImpl getCharacterService() {
        if (characterService == null) {
            characterService = new CharacterServiceImpl();
        }
        log.info("Получили Реализацию сервиса персонажей.");
        return characterService;
    }

    @Override
    public Collection<Character> getAllEntities() {
        Collection<Character> characters = characterRepository.getAll();
        log.info("Получаем полный список персонажей из базы. Кол-во: " + characters.size());
        return characters;
    }

    @Override
    public Optional<Character> getEntity(long id) {
        Optional<Character> character = characterRepository.get(id);
        if (character.isPresent()) {
            log.info("Получаем персонажа: " + character.get().getName());
        } else {
            log.info("Персонаж с id#: " + id + " отсутствует");
        }
        return character;
    }

    @Override
    public long saveEntity(Character character) {
        log.info("Сохраняем нового персонажа: " + character.getName());
        characterRepository.save(character);
        return 0;
    }

    @Override
    public void updateEntity(long id, Character newEntity) {

    }


}
