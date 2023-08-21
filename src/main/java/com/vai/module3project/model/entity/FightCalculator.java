package com.vai.module3project.model.entity;

public class FightCalculator {
    public static int damageCalculation(int power, int health) {
        return 0;
    }
    public static int gameIsOverCheck(int playerHealth, int enemyHealth) {
        if (enemyHealth <= 0 && playerHealth <= 0) {
            return 1;
        } else if (enemyHealth <= 0) {
            return 2;
        } else if (playerHealth <= 0) {
            return 3;
        } else {
            return 0;
        }
    }
    public static int healthCheck(int health) {
        if (health <= 0) {
            return 0;
        } else {
            return health;
        }
    }
}

