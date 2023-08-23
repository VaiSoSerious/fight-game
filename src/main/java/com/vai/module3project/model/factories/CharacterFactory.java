package com.vai.module3project.model.factories;

import com.vai.module3project.model.entity.Character;

public interface CharacterFactory {
    Character create(String name, int power, int health, boolean turn);
}
