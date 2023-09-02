package com.vai.module3project.model.entity;

import lombok.extern.log4j.Log4j2;

import java.util.Random;

@Log4j2
public class FightCalculator {

    private static String attackingCharacterHitText;
    private static int defensiveCharacterHealth;

    public static void hit(Character attackingCharacter, Character defensiveCharacter) {
        int attackingCharacterDamage = attackingCharacter.getCharacterClass().getPower();
        boolean crit = criticalHit();
        String critText = crit?" критического":"";
        if (crit) {
            log.info(attackingCharacter + " наносит критический удар!");
            attackingCharacterDamage *= 2;
        }
        defensiveCharacterHealth = defensiveCharacter.getHealth() - attackingCharacterDamage;
        attackingCharacterHitText = attackingCharacter.getCharacterClass().getHit()
                + " Нанеся: " + attackingCharacterDamage + critText +  " урона.";
    }

    public static String getAttackingCharacterHitText() {
        return attackingCharacterHitText;
    }

    public static int getDefensiveCharacterHealth() {
        return defensiveCharacterHealth;
    }
    private static boolean criticalHit() {
        Random random = new Random();
        int result = random.nextInt(2);
//        return result > 0;
        return result > 0? true:false;
    }
}

