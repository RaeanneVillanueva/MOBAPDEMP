package com.example.mobapdemp;

public class Player extends Character{

    private int health;
    private int social;
    private int money;
    private int grades;
    private int term;

    public Player(String name, int imagePath){
        super(name, imagePath);
        this.health = 50;
        this.social = 50;
        this.money = 50;
        this.grades = 50;
        this.term = 0;
    }

    public Player(){
        this(null,0);
    }

    public void setChanges(Consequence consequence){
        this.health += consequence.getHealth();
        this.social += consequence.getSocial();
        this.money += consequence.getMoney();
        this.grades += consequence.getGrades();
    }

    public boolean isSurviving(){
        if(health>0&&health<100&&social>0&&social<100&&money>0&&money<100&&grades>0&&grades<100) return true;
        return false;
    }

    public int getHealth() {
        return health;
    }

    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        this.social = social;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public String getName() { return super.getCharacterName(); }

    public void setName(String name) { super.setCharacterName(name );}

    public int getImagePath(){ return super.getImagePath();}

    public void setImagePath(int imagePath){super.setImagePath(imagePath);}
}
