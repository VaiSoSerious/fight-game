package com.vai.module3project.model.factories;

import com.vai.module3project.model.entity.Character;
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
    public Character create(String name, int power, int health, boolean turn) {
        Character character = new Character();
        character.setName(name);
        character.setPower(power);
        character.setHealth(health);
        character.setTurn(turn);
        log.info("Создали нового персонажа: " + name);
        return character;
    }
}
