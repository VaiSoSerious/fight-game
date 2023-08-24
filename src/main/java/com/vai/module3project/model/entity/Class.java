package com.vai.module3project.model.entity;

public enum Class {
    ADMIN("Game master"),
    BACKEND("Backend разработчик"),
    DEVOPS("Devops инженер"),
    FRONTEND("Frontend разработчик"),
    ENEMY("Соперник");
    private String tittle;

    Class(String tittle) {
        this.tittle = tittle;
    }
    public String getTittle(){
        return this.tittle;
    }
}

