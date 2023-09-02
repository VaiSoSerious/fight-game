package com.vai.module3project.model.entity;

public enum Class {
    ADMIN("Game master", 20, 500, 100,  "делает удар баном по щам."),
    BACKEND("Backend разработчик", 15, 70, 30,  "делает выстрел json'ом в голову."),
    DEVOPS("Devops инженер",  5, 200, 30, "роняет мозговой сервер соперника."),
    FRONTEND("Frontend разработчик", 10, 100, 30,  "применяет глазовырывающую верстку."),
    LOCALBASTARD("Местный забулдыга", 3, 85, 5, "бормочит что-то непонятное и кидает пустую бутылку."),
    GRANDMAATTHEDOOR("Бабка у подъезда", 5, 100, 10, "обозвала проституткой."),
    YOBJOCK("Качек-гопник", 15, 150, 50, "говорит: \"Эй дядя, закурить не найдётся?\"");
    private String tittle;
    private String hit;
    private int power;
    private int health;
    private int experience;

    Class(String tittle, int power, int health, int experience, String hit) {
        this.tittle = tittle;
        this.hit = hit;
        this.health = health;
        this.experience = experience;
        this.power = power;
    }
    public String getTittle(){
        return this.tittle;
    }

    public String getHit() {
        return hit;
    }

    public int getPower() {
        return power;
    }

    public int getHealth() {
        return health;
    }

    public int getExperience() {
        return experience;
    }
}

