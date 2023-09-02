package com.vai.module3project.model.entity;

public class FightCalculator {

    private static String attackingCharacterHitText;
    private static int defensiveCharacterHealth;

    public static void hit(Character attackingCharacter, Character defensiveCharacter) {
        int attackingCharacterDamage = attackingCharacter.getCharacterClass().getPower();
        defensiveCharacterHealth = defensiveCharacter.getHealth() - attackingCharacterDamage;
        attackingCharacterHitText = attackingCharacter.getCharacterClass().getHit()
                + " Нанеся: " + attackingCharacterDamage + " урона.";
    }

    public static String getAttackingCharacterHitText() {
        return attackingCharacterHitText;
    }

    public static int getDefensiveCharacterHealth() {
        return defensiveCharacterHealth;
    }
}

