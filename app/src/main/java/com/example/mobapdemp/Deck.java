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

        cards.add(  new ScenarioCard(AppConstants.MOM, "DCAT is coming, you should study!",
                new Choice("Ok", new Consequence(-5, 0, 15, 0), "Welcome to DLSU"),
                new Choice("Pfft. No", new Consequence(0, 0, -50, 0), "You failed 0/100...")));

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
