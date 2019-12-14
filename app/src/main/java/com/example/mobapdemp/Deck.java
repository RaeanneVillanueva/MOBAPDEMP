package com.example.mobapdemp;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;

    public Deck(){

    }

    public void initializeStandardDeck(){
        cards = new ArrayList<>();

        cards.add(  new ScenarioCard(AppConstants.MOM, "DCAT is coming, you should study!",
                    new Choice("Ok", new Consequence(-5, 0, 15, 0), "Welcome to DLSU"),
                    new Choice("Pfft. No", new Consequence(0, 0, -50, 0), "You failed 0/100...")));

        cards.add(  new ScenarioCard(AppConstants.MOM, "Go home now! It's late already",
                new Choice("Book a grab", new Consequence(10, 0, 0, -15)),
                new Choice("LRT", new Consequence(-10, 0, 0, 0))));

        cards.add(  new ScenarioCard(AppConstants.DAD, "Here's your allowance, enjoy!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));

        cards.add(  new ScenarioCard(AppConstants.JYLE, "Miss you, mumsh!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));

        cards.add(  new ScenarioCard(AppConstants.BEK, "Miss you, mumsh!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));

        cards.add(  new ScenarioCard(AppConstants.BOB, "Miss you, mumsh!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));

        cards.add(  new ScenarioCard(AppConstants.JAMES, "Miss you, mumsh!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));

        cards.add(  new ScenarioCard(AppConstants.JEAN, "Miss you, mumsh!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));

        cards.add(  new ScenarioCard(AppConstants.JEANETTE, "Miss you, mumsh!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));

        cards.add(  new ScenarioCard(AppConstants.PROFESSOR1, "Miss you, mumsh!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));

        cards.add(  new ScenarioCard(AppConstants.PROFESSOR2, "Miss you, mumsh!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));

        cards.add(  new ScenarioCard(AppConstants.UPPERCLASSMEN1, "Miss you, mumsh!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));


        cards.add(  new ScenarioCard(AppConstants.UPPERCLASSMEN2, "Miss you, mumsh!",
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "Welcome to DLSU"),
                new Choice("Thanks!", new Consequence(0, 0, 0, 20), "You failed 0/100...")));

        cards.add(new ScenarioCard(AppConstants.LONELINESS, "You became very lonely that you don't have group mates.",
                new Choice("", new Consequence(0,0,0,0), ""),
                new Choice("", new Consequence(0,0,0,0), "")));

        cards.add(new ScenarioCard(AppConstants.DRUGS, "You ended up being peer pressured to take drugs and got addicted to it.",
                new Choice("", new Consequence(0,0,0,0), ""),
                new Choice("", new Consequence(0,0,0,0), "")));

        cards.add(new ScenarioCard(AppConstants.VOMIT, "You partied too hard and vomitted.",
                new Choice("", new Consequence(0,0,0,0), ""),
                new Choice("", new Consequence(0,0,0,0), "")));

        cards.add(new ScenarioCard(AppConstants.STARVE, "You don't money and ended up starving to death.",
                new Choice("", new Consequence(0,0,0,0), ""),
                new Choice("", new Consequence(0,0,0,0), "")));


        cards.add(new NarrationCard("This is a narration, nice!"));

    }

    public void initializeCustomDeck(Deck deck){
        this.cards = deck.getCards();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
