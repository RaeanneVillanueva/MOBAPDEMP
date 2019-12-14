package com.example.mobapdemp;

import java.util.ArrayList;

public class Deck {



    private ArrayList<Card> queue;
    private ArrayList<ScenarioCard> scenarioCards;
    private String name;

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

        scenarioCards.add(  new ScenarioCard(AppConstants.MOM, "Go home now! It's late already",
                new Choice("Book a grab", new Consequence(10, 0, 0, -15)),
                new Choice("LRT", new Consequence(-10, 0, 0, 0))));

        scenarioCards.add(  new ScenarioCard(AppConstants.DAD, "Here's your allowance, enjoy!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));

        scenarioCards.add(  new ScenarioCard(AppConstants.JYLE, "Miss you, mumsh!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));

        scenarioCards.add(  new ScenarioCard(AppConstants.BEK, "Miss you, mumsh!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));

        scenarioCards.add(  new ScenarioCard(AppConstants.BOB, "Miss you, mumsh!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));

        scenarioCards.add(  new ScenarioCard(AppConstants.JAMES, "Miss you, mumsh!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));

        scenarioCards.add(  new ScenarioCard(AppConstants.JEAN, "Miss you, mumsh!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));

        scenarioCards.add(  new ScenarioCard(AppConstants.JEANETTE, "Miss you, mumsh!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));

        scenarioCards.add(  new ScenarioCard(AppConstants.PROFESSOR1, "Miss you, mumsh!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));

        scenarioCards.add(  new ScenarioCard(AppConstants.PROFESSOR2, "Miss you, mumsh!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));

        scenarioCards.add(  new ScenarioCard(AppConstants.UPPERCLASSMEN1, "Miss you, mumsh!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));


        scenarioCards.add(  new ScenarioCard(AppConstants.UPPERCLASSMEN2, "Miss you, mumsh!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));

        scenarioCards.add(new ScenarioCard(AppConstants.LONELINESS, "You became very lonely that you don't have group mates.",
                new Choice("", new Consequence(0,0,0,0), ""),
                new Choice("", new Consequence(0,0,0,0), "")));

        scenarioCards.add(new ScenarioCard(AppConstants.DRUGS, "You ended up being peer pressured to take drugs and got addicted to it.",
                new Choice("", new Consequence(0,0,0,0), ""),
                new Choice("", new Consequence(0,0,0,0), "")));

        scenarioCards.add(new ScenarioCard(AppConstants.VOMIT, "You partied too hard and vomitted.",
                new Choice("", new Consequence(0,0,0,0), ""),
                new Choice("", new Consequence(0,0,0,0), "")));

        scenarioCards.add(new ScenarioCard(AppConstants.STARVE, "You don't money and ended up starving to death.",
                new Choice("", new Consequence(0,0,0,0), ""),
                new Choice("", new Consequence(0,0,0,0), "")));

    }

    public void initializeCustomDeck(Deck deck) {
        this.scenarioCards = deck.getCards();
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

}
