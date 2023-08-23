package com.vai.module3project.model.services;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.factories.CharacterFactory;

public interface CharacterService<Character> extends CRUDService<Character> {
    CharacterFactory getCharacterFactory();
}
