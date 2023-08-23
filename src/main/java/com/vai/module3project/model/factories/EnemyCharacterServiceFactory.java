package com.vai.module3project.model.factories;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.services.CharacterServiceImpl;
import com.vai.module3project.model.services.CRUDService;

public class EnemyCharacterServiceFactory implements CharacterServiceFactory<Character> {
    @Override
    public CRUDService<Character> createService() {
        return new CharacterServiceImpl();
    }
}
