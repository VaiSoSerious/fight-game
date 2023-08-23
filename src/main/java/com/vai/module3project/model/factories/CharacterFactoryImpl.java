package com.vai.module3project.model.factories;

import com.vai.module3project.model.entity.Character;

public class CharacterFactoryImpl implements CharacterFactory{
    @Override
    public Character create(String name, int power, int health, boolean turn) {
        Character character = new Character();
        character.setName(name);
        character.setPower(power);
        character.setHealth(health);
        character.setTurn(turn);
        return character;
    }
}
