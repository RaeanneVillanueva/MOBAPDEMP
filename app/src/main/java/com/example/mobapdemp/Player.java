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

    public Player(String name){

        this(name, 0);
    }

    public Player(){
        this(null,0);
    }

    public void change(Consequence consequence){

        setHealth(this.health + consequence.getHealth());
        setSocial(this.social + consequence.getSocial());
        setMoney(this.money + consequence.getMoney());
        setGrades(this.grades + consequence.getGrades());
    }

    public boolean isSurviving(){
        if(health>0&&health<100&&social>0&&social<100&&money>0&&money<100&&grades>0&&grades<100) return true;
        return false;
    }

    public String causeOfDeath(){
        if(health<=0||health>=100) return "health" + health;
        if(social<=0||social>=100) return "social" + social;
        if(money<=0||money>=100) return "money" + money;
        if(grades<=0||grades>=100) return "grades" + grades;
        return null;

    }

    public int getHealth() {
        return health;
    }

    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        if(social >= 100) this.social = 100;
        if(social <= 0) this.social = 0;
        this.social = social;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if(money >= 100) this.money = 100;
        if(money <= 0) this.money = 0;
        this.money = money;
    }

    public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        if(grades >= 100) this.grades = 100;
        if(grades <= 0) this.grades = 0;
        this.grades = grades;
    }

    public void setHealth(int health) {
        if(health >= 100) this.health = 100;
        if(health <= 0) this.health = 0;
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
