package com.vai.module3project.model.factories;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.entity.Class;

public interface CharacterFactory {
    Character create(String name, int health, boolean turn, Class characterClass);
}
