package com.vai.module3project.model.factories;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.entity.Class;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CharacterFactoryImpl implements CharacterFactory{
    private static CharacterFactory characterFactory;

    private CharacterFactoryImpl() {
        log.info("Создали новую Фабрику персонажей");
    }

    public static CharacterFactory getCharacterFactory() {
        if (characterFactory == null) {
            characterFactory = new CharacterFactoryImpl();
        }
        log.info("Получили Фабрику персонажей");
        return characterFactory;
    }

    @Override
    public Character create(String name, int power, int health, boolean turn, Class characterClass) {
        Character character = new Character();
        character.setName(name);
        character.setPower(power);
        character.setHealth(health);
        character.setTurn(turn);
        character.setCharacterClass(characterClass);
        log.info("Создали нового персонажа: " + name);
        return character;
    }
}
