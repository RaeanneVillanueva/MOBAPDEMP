package com.example.mobapdemp;

import java.util.ArrayList;

public class Deck {


    private String id;
    private ArrayList<Card> queue;
    private ArrayList<ScenarioCard> scenarioCards;
    private String name;
    private String owner;

    public Deck(String id, String name, String owner){
        this(id, name);
        this.owner = owner;
    }

    public Deck(String id, String name){
        this(name);
        this.id = id;
    }

    public Deck(String name){
        this();
        this.name = name;
    }

    public Deck(){
        queue = new ArrayList<>();
        scenarioCards = new ArrayList<>();
    }

    public void initializeStandardDeck(){

        scenarioCards.add(  new ScenarioCard(AppConstants.MOM, "DCAT is coming, you should study!",
                    new Choice("Ok", new Consequence(-5, 0, 15, 0), "Welcome to DLSU"),
                    new Choice("Pfft. No", new Consequence(0, 0, -50, 0), "You failed 0/100...")));

        scenarioCards.add(  new ScenarioCard(AppConstants.DAD, "Here's your allowance, enjoy!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), ""),
                new Choice("No need, Dad!", new Consequence(0, 0, 0, 0), "")));


        scenarioCards.add(  new ScenarioCard(AppConstants.JAMES, "Hi, I am from Shavier Academy! I like to weightlift in my free time!",
                new Choice("Hi!", new Consequence(10, 0, 0, 0)),
                new Choice("Hi!", new Consequence(-10, 0, 0, 0))));

        scenarioCards.add(  new ScenarioCard(AppConstants.JEAN, " Hi, I am from Dos High School! I know how to play drums!",
                new Choice("Hi!", new Consequence(0, 0, 0, 0), ""),
                new Choice("Hi!", new Consequence(0, 0, 0, 0), "")));

        scenarioCards.add(  new ScenarioCard(AppConstants.BEK, "Hi, I am from Shanghai Shek College! I like to draw!",
                new Choice("Hi!", new Consequence(0, 0, 0, 0), ""),
                new Choice("Hi!", new Consequence(0, 0, 0, 0), "")));

        scenarioCards.add(  new ScenarioCard(AppConstants.JYLE, "Hi, I am from Atenew High School! Reading is my hobby.",
                new Choice("Hi!", new Consequence(0, 0, 0, 0), ""),
                new Choice("Hi!", new Consequence(0, 0, 0, 0), "")));

        scenarioCards.add(  new ScenarioCard(AppConstants.UPPERCLASSMEN1, "Hey frosh! Would like to join us for dinner? Your blockmates are coming too!",
                new Choice("Sure!", new Consequence(0, 5, 0, -5), ""),
                new Choice("I'm going home", new Consequence(0, -5, 0, 0), "")));

        scenarioCards.add(  new ScenarioCard(AppConstants.UPPERCLASSMEN2, "Hey there! I am inviting you to our afterparty. Can you join us?",
                new Choice("G!", new Consequence(0, 10, 0, -5), "You gained a lot of friends because of the party!"),
                new Choice("Need to go home", new Consequence(0, -5, 0, 0), "You ended up forcefully going to the party. You did not enjoy it.")));

        //ended up going to the party

        scenarioCards.add(  new ScenarioCard(AppConstants.MOM, "Go home now!",
                new Choice("Book a Grab", new Consequence(0, 0, 0, -20), ""),
                new Choice("LRT", new Consequence(-5, 0, 0, 0), "")));

        //Recruitment Week

        scenarioCards.add(  new ScenarioCard(AppConstants.UPPERCLASSMEN1, "Welcome to our annual recruitment week!",
                new Choice("Wow!", new Consequence(0, 0, 0, 0), "Welcome to DLSU"),
                new Choice("Nice", new Consequence(0, 0, 0, 0), "You failed 0/100...")));

        scenarioCards.add(  new ScenarioCard(AppConstants.UPPERCLASSMEN1, "Join our organization and be a part of a committee! Your blockmates are joining too!",
                new Choice("Sure!", new Consequence(0, 5, 0, -15), "Welcome to DLSU"),
                new Choice("Not interested..", new Consequence(0, -3, 0, 0), "You failed 0/100...")));

        scenarioCards.add(  new ScenarioCard(AppConstants.JYLE, "They said it can help with our resume in the future. Come on, Join with me!",
                new Choice("Nice!", new Consequence(0, 0, 3, 0), "Welcome to DLSU"),
                new Choice("No thanks..", new Consequence(0, -2, -5, 0), "You failed 0/100...")));


        scenarioCards.add(  new ScenarioCard(AppConstants.JAMES, "Hey! We’re forming groups of five for the membership, would you like to join us?",
                new Choice("Yes!", new Consequence(0, 10, 0, 10), "You gained more new friends and get to save money from membership fee!"),
                new Choice("No thanks..", new Consequence(0, -5, 0, 20), "You ended up joining and paid the non-discounted membership fee.")));


        scenarioCards.add(new ScenarioCard(AppConstants.UPPERCLASSMEN2, "Join our Junior Officership and gain leadership skills! Invite your friends to join too!",
                new Choice("Yes!", new Consequence(0,3,3,0), ""),
                new Choice("No.", new Consequence(0,-3,-2,0), "")));

        scenarioCards.add(new ScenarioCard(AppConstants.PROFESSOR1, "We’ll be having a graded recitation tomorrow. Please be ready and review the slides.",
                new Choice("Ugh", new Consequence(0,0,0,0), ""),
                new Choice("Okay..", new Consequence(0,0,0,0), "")));

        scenarioCards.add(new ScenarioCard(AppConstants.UPPERCLASSMEN2, "We’ll be having our first General Assembly later! I hope you can come!",
                new Choice("I have to study..", new Consequence(0,-5,5,0), ""),
                new Choice("Sure!", new Consequence(0,7,-6,0), "")));

        scenarioCards.add(new ScenarioCard(AppConstants.UPPERCLASSMEN1, "Let's have IceBreakers! Join the game!",
                new Choice("I'm shy..", new Consequence(0,-2,0,0), ""),
                new Choice("What to do??", new Consequence(0,3,0,0), "")));

        scenarioCards.add(new ScenarioCard(AppConstants.BEK, "Let’s join the General Assembly, let’s meet new friends! Our other blockmates will come too! Let’s study for the graded recitation after.",
                new Choice("Yea sure!", new Consequence(-4,5,-3,0), "You gained a lot of friends today! However, you were not able to recite."),
                new Choice("Priorities..", new Consequence(3,-5,5,0), "You were able to study of the graded recitation. However, the professor forgot about it.")));


    }

    public void initializeCustomDeck(Deck deck) {
        this.scenarioCards = deck.getCards();
    }

    public void enQueueCards(){
        queue.addAll(scenarioCards);
    }

    public ArrayList<ScenarioCard> getCards() {
        return scenarioCards;
    }

    public ArrayList<Card> getQueue() {
        return queue;
    }

    public void setQueue(ArrayList<Card> queue) {
        this.queue = queue;
    }

    public void setCards(ArrayList<ScenarioCard> scenarioCards) {
        this.scenarioCards = scenarioCards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ScenarioCard> getScenarioCards() {
        return scenarioCards;
    }

    public void setScenarioCards(ArrayList<ScenarioCard> scenarioCards) {
        this.scenarioCards = scenarioCards;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


}
