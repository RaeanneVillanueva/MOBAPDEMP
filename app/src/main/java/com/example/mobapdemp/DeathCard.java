package com.example.mobapdemp;

public class DeathCard extends ScenarioCard {
    public DeathCard(Character character, String scenarioText){
        super(character, scenarioText, new Choice("what.."), new Choice("Oh.."));
    }
}
