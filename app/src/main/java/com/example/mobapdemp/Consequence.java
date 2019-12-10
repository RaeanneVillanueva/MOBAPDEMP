package com.example.mobapdemp;

public class Consequence {
    private int health;
    private int social;
    private int grades;
    private int money;

    public Consequence(int health, int social, int grades, int money){
        this.health = health;
        this.social = social;
        this.grades = grades;
        this.money = money;
    }

    public Consequence(){
        this.health = 0;
        this.social = 0;
        this.grades = 0;
        this.money = 0;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        this.social = social;
    }

    public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
