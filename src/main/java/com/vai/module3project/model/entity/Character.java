package com.vai.module3project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Character {
    private boolean turn;
    int health;
    int power;
    String name;
    Class characterClass;

    public int hit() {
        return this.power;
    }
}
