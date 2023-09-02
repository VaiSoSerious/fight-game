package com.vai.module3project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Character implements Cloneable {
    private boolean turn;
    int health;
//    int power;
    String name;
    Class characterClass;
    int level = 1;
    int percents = 0;

    @Override
    public Character clone() {
        try {
            Character clone = (Character) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    public void checkLevel() {
        if (percents >= 100) {
            this.level += (percents/100);
            this.percents = percents%100;
        }
    }
    public void increasePercents(int experience) {
        this.percents += experience;
        checkLevel();
    }
}
