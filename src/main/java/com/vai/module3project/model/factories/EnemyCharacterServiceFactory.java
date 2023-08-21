package com.vai.module3project.model.factories;

import com.vai.module3project.model.entity.Character;
import com.vai.module3project.model.services.EnemyCharacterService;
import com.vai.module3project.model.services.CRUDService;

public class EnemyCharacterServiceFactory implements ServiceFactory<Character> {
    @Override
    public CRUDService<Character> createService() {
        return new EnemyCharacterService();
    }
}
