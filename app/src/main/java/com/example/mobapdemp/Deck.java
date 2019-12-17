package com.example.mobapdemp;

import android.os.DeadObjectException;

import java.util.ArrayList;

public class Deck {


    private String id;
    private ArrayList<Card> queue;
    private ArrayList<ScenarioCard> scenarioCards;
    private String name;
    private User owner;

    public Deck(String id, String name, User owner){
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
        this.name = "standard";
        this.id = "0";


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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }


}
